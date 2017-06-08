package concurrent.share._03callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


/**
 * 使用CompletionService(完成服务)
 * 
 * @author ken
 * @param <V>
 * 2017-3-21 下午02:31:47
 */

public class TaskWithResult3<V> implements Callable<V> {
	private String id;
	public TaskWithResult3() {}
	public TaskWithResult3(String id) {
		this.id = id;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public V call() throws Exception {
		return (V) (Thread.currentThread() + ":" + id);
	}
	/**
	 * 如果你向Executor提交了一个批处理任务，并且希望在它们完成后获得结果。
	 * 为此你可以保存与每个任务相关联的Future，然后不断地调用timeout为零的get，
	 * 来检验Future是否完成。这样做固然可以，但却相当乏味。
	 * 幸运的是，还有一个更好的方法：完成服务(CompletionService)
	 * 
	 * ExecutorCompletionService<V>本身有管理任务队列的功能
     *  i. ExecutorCompletionService内部维护列一个队列, 用于管理已完成的任务
     *  ii. 内部还维护列一个Executor, 可以执行任务
     *
     * ExecutorCompletionService内部维护了一个BlockingQueue, 只有完成的任务才被加入到队列中
     *
     * 任务一完成就加入到内置管理队列中, 如果队列中的数据为空时,调用take()就会阻塞 (等待任务完成)
     *  i. 关于完成任务是如何加入到完成队列中的, 请参考ExecutorCompletionService的内部类QueueingFuture的done()方法
	 * 
	 * 包含方法：
	 * Future<V> submit(Callable<V> task);
	 * 			执行任务时会创建一个QueueingFuture,然后将创建的QueueingFuture丢给executor, 
	 * 			让executor完成任务的执行工作QueueingFuture继承与FutureTask类, 
	 * 			而FutureTask实现了两个接口Runnable和Future.
	 * Future<V> submit(Runnable task, V result); 
	 * Future<V> take() throws InterruptedException;
	 * 			阻塞的，若当前无结果，则线程阻塞，直到产生一个结果，被取出(移出队列)后返回，线程才继续运行。
	 * Future<V> poll();
	 * 			非阻塞的,如果完成队列中有数据就返回(移出队列), 否则返回null，线程继续运行不阻塞。
	 * Future<V> poll(long timeout, TimeUnit unit) throws InterruptedException;
	 * 			如果完成队列中有数据就直接返回, 否则等待指定的时间, 到时间后如果还是没有数据就返回null
	 * 
	 * @param exe
	 * 2017-3-21 下午03:35:41
	 */
	static void completionService(ExecutorService exe){
		try {
			System.out.println("method completionService()");
			CompletionService<String> cs = new ExecutorCompletionService<String>(exe);
			for (int i = 0; i < 3; i++) {
				cs.submit(new TaskWithResult3<String>(i + ""));
				TimeUnit.SECONDS.sleep(5);
				Future<String> future = cs.poll();
				if (future.isDone())
					System.out.println("future.get():" + future.get());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} finally {
			exe.shutdown();
		}
	}
	
	/**
	 * <一> 
	 * 1. 用List收集任务结果 (List记录每个submit返回的Future) 
	 * 2. 循环查看结果, Future不一定完成, 如果没有完成, 那么调用get会租塞
	 * 
	 * 3. 如果排在前面的任务没有完成, 那么就会阻塞, 这样后面已经完成的任务就没法获得结果了,
	 * 导致了不必要的等待时间. 更为严重的是: 第一个任务如果几个小时或永远完成不了,
	 * 而后面的任务几秒钟就完成了, 那么后面的任务的结果都将得不到处理
	 * 
	 * 导致: 已完成的任务可能得不到及时处理
	 */
	static void case1(ExecutorService service) {
		try {
			List<Future<String>> list = new ArrayList<Future<String>>();
			for (int i = 0; i < 10; i++) {
				// 搜集任务结果
				list.add(service.submit(new Callable<String>() {
					public String call() throws Exception {
						TimeUnit.SECONDS.sleep(2);
						return Thread.currentThread().getName();
					}
				}));
			}
			// 处理任务结果
			int count = 0;
			for (Future<String> future : list) {
				System.out.println(future.get());
				count++;
			}
			System.out.println(count + " task done !");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}finally{
			service.shutdown();
		}
	}
	/**
     * <二> 只对第一种情况进行的改进
     *      1. 查看任务是否完成, 如果完成, 就获取任务的结果, 让后重任务列表中删除任务.
     *      2. 如果任务未完成, 就跳过此任务, 继续查看下一个任务结果.
     *      3. 如果到了任务列表末端, 那么就从新回到任务列表开始, 然后继续从第一步开始执行
     *
     *      这样就可以及时处理已完成任务的结果了
     */
     static void case2( ExecutorService service ){
        try {
			List<Future<String>> results = new ArrayList<Future<String>>();
			for(int i=0; i<10; i++) {
			    Callable<String> task = new Callable<String>() {
			        public String call() throws Exception {
			            TimeUnit.SECONDS.sleep(2); //模拟耗时操作
			            return Thread.currentThread().getName();
			        }
			    };
			    results.add(service.submit(task)); 
			}
			int count = 0;
			for(int i=0; i<results.size(); i++) {
			    Future<String> taskHolder = results.get(i);
			    if(taskHolder.isDone()) { 
			        String result = taskHolder.get(); //获取结果, 进行某些操作
			        System.out.println("result: " + result);
			        results.remove(taskHolder);//任务完成,就清除任务
			        i--;
			        count++; //完成的任务的计数器
			    }
			    if(i == results.size() - 1) 
			    	i = -1;
			}
			System.out.println(count + " task done !");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}finally{
			service.shutdown();
		}
    }
     /**
      * <三> 使用ExecutorCompletionService管理异步任务
      * 
      * 解决了已完成任务得不到及时处理的问题
     * @throws InterruptedException 
      */
	static void case3(final ExecutorService service, final int size) throws InterruptedException {
		final CompletionService<String> completionService = new ExecutorCompletionService<String>(
				service);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < size; i++) {
					completionService.submit(new Callable<String>() {
						@Override
						public String call() throws Exception {
							System.out.println("submit product:"+Thread.currentThread().getName());
							return Thread.currentThread().getName();
						}
					});
				}
			}

		}).start();
		TimeUnit.SECONDS.sleep(2);
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("customer:"+Thread.currentThread().getName());
				try {
					int completionTask = 0;
					while (completionTask < size) {
						// 如果完成队列中没有数据, 则阻塞; 否则返回队列中的数据
						Future<String> resultHolder = completionService.take();
						System.out.println("result: " + resultHolder.get());
						completionTask++;
					}
					System.out.println(completionTask + " task done !");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}

		}).start();
		service.shutdown();
	}
	public static void main(String[] args) throws InterruptedException {
		final ExecutorService exe = Executors.newCachedThreadPool();
//		completionService(exe);
		case3(exe,10);
	}
}
