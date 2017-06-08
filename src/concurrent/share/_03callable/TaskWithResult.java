package concurrent.share._03callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 使用Future
 * 线程是属于异步计算模型，所以你不可能直接从别的线程中得到函数返回值。
 * 这时候，Future就出场了。Futrue可以监视目标线程调用call的情况，
 * 当你调用Future的get()方法以获得结果时，当前线程就开始阻塞，直接call方法结束返回结果
 * 
 * Future接口中声明了5个方法： 
 * cancel(boolean mayInterruptIfRunning)方法用来取消任务.
 * 
 * 如果取消任务成功则返回true，如果取消任务失败则返回false。
 * 参数mayInterruptIfRunning表示是否允许取消正在执行却没有执行完毕的任务，
 * 如果设置true，则表示可以取消正在执行过程中的任务。
 * 如果任务已经完成，则无论mayInterruptIfRunning为true还是false，此方法肯定返回false,即如果取消已经完成的任务会返回false；
 * 如果任务正在执行，若mayInterruptIfRunning设置为true，则返回true，若mayInterruptIfRunning设置为false,则返回false；
 * 如果任务还没有执行,则无论mayInterruptIfRunning为true还是false，肯定返回true。
 * 
 * isCancelled方法表示任务是否被取消成功，如果在任务正常完成前被取消成功，则返回 true。
 * isDone方法表示任务是否已经完成，若任务完成，则返回true； 
 * get()方法用来获取执行结果，这个方法会产生阻塞，会一直等到任务执行完毕才返回；
 * 
 * get(long timeout, TimeUnit unit)用来获取执行结果,如果在指定时间内，还没获取到结果，就直接返回null。
 * 
 * @author ken
 * @param <V>
 *            2017-3-21 下午02:32:01
 */
public class TaskWithResult<V> implements Callable<V> {
	
	private int id;
	public TaskWithResult(int id) {
		this.id = id;
	}

	// 和run()方法区别是：call方法可以抛出异常
	@SuppressWarnings("unchecked")
	@Override
	public V call() throws Exception {
		return (V) (Thread.currentThread() + ":" + id);
	}
	
	static void futureList(ExecutorService exe){
		try {
			List<Future<?>> list = new ArrayList<Future<?>>();
			for (int i = 0; i < 5; i++) {
				TimeUnit.SECONDS.sleep(2);// 模拟执行其他的任务
				list.add(exe.submit(new TaskWithResult<String>(i)));
			}
			for (Future<?> fs : list) {
				if(fs.isDone())
					System.out.println(fs.get());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}finally{
			exe.shutdown();
		}
	}
	/**
	 * submit()方法产生Future对象
	 * 
	 * 假设有一个很耗时的返回值需要计算，并且这个返回值不是立刻需要的话，
	 * 那么就可以用一个线程去计算返回值，而当前线程在使用这个返回值之前可以做其它的操作，
	 * 等到需要这个返回值时，再通过Future得到.
	 * @param exe
	 * 2017-3-21 下午02:34:04
	 */
	public static void main(String[] args) {
		ExecutorService exe = Executors.newCachedThreadPool();
		futureList(exe);
	}
}
