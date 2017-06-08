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
 * ʹ��CompletionService(��ɷ���)
 * 
 * @author ken
 * @param <V>
 * 2017-3-21 ����02:31:47
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
	 * �������Executor�ύ��һ�����������񣬲���ϣ����������ɺ��ý����
	 * Ϊ������Ա�����ÿ�������������Future��Ȼ�󲻶ϵص���timeoutΪ���get��
	 * ������Future�Ƿ���ɡ���������Ȼ���ԣ���ȴ�൱��ζ��
	 * ���˵��ǣ�����һ�����õķ�������ɷ���(CompletionService)
	 * 
	 * ExecutorCompletionService<V>�����й���������еĹ���
     *  i. ExecutorCompletionService�ڲ�ά����һ������, ���ڹ�������ɵ�����
     *  ii. �ڲ���ά����һ��Executor, ����ִ������
     *
     * ExecutorCompletionService�ڲ�ά����һ��BlockingQueue, ֻ����ɵ�����ű����뵽������
     *
     * ����һ��ɾͼ��뵽���ù��������, ��������е�����Ϊ��ʱ,����take()�ͻ����� (�ȴ��������)
     *  i. ���������������μ��뵽��ɶ����е�, ��ο�ExecutorCompletionService���ڲ���QueueingFuture��done()����
	 * 
	 * ����������
	 * Future<V> submit(Callable<V> task);
	 * 			ִ������ʱ�ᴴ��һ��QueueingFuture,Ȼ�󽫴�����QueueingFuture����executor, 
	 * 			��executor��������ִ�й���QueueingFuture�̳���FutureTask��, 
	 * 			��FutureTaskʵ���������ӿ�Runnable��Future.
	 * Future<V> submit(Runnable task, V result); 
	 * Future<V> take() throws InterruptedException;
	 * 			�����ģ�����ǰ�޽�������߳�������ֱ������һ���������ȡ��(�Ƴ�����)�󷵻أ��̲߳ż������С�
	 * Future<V> poll();
	 * 			��������,�����ɶ����������ݾͷ���(�Ƴ�����), ���򷵻�null���̼߳������в�������
	 * Future<V> poll(long timeout, TimeUnit unit) throws InterruptedException;
	 * 			�����ɶ����������ݾ�ֱ�ӷ���, ����ȴ�ָ����ʱ��, ��ʱ����������û�����ݾͷ���null
	 * 
	 * @param exe
	 * 2017-3-21 ����03:35:41
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
	 * <һ> 
	 * 1. ��List�ռ������� (List��¼ÿ��submit���ص�Future) 
	 * 2. ѭ���鿴���, Future��һ�����, ���û�����, ��ô����get������
	 * 
	 * 3. �������ǰ�������û�����, ��ô�ͻ�����, ���������Ѿ���ɵ������û����ý����,
	 * �����˲���Ҫ�ĵȴ�ʱ��. ��Ϊ���ص���: ��һ�������������Сʱ����Զ��ɲ���,
	 * ��������������Ӿ������, ��ô���������Ľ�������ò�������
	 * 
	 * ����: ����ɵ�������ܵò�����ʱ����
	 */
	static void case1(ExecutorService service) {
		try {
			List<Future<String>> list = new ArrayList<Future<String>>();
			for (int i = 0; i < 10; i++) {
				// �Ѽ�������
				list.add(service.submit(new Callable<String>() {
					public String call() throws Exception {
						TimeUnit.SECONDS.sleep(2);
						return Thread.currentThread().getName();
					}
				}));
			}
			// ����������
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
     * <��> ֻ�Ե�һ��������еĸĽ�
     *      1. �鿴�����Ƿ����, ������, �ͻ�ȡ����Ľ��, �ú��������б���ɾ������.
     *      2. �������δ���, ������������, �����鿴��һ��������.
     *      3. ������������б�ĩ��, ��ô�ʹ��»ص������б�ʼ, Ȼ������ӵ�һ����ʼִ��
     *
     *      �����Ϳ��Լ�ʱ�������������Ľ����
     */
     static void case2( ExecutorService service ){
        try {
			List<Future<String>> results = new ArrayList<Future<String>>();
			for(int i=0; i<10; i++) {
			    Callable<String> task = new Callable<String>() {
			        public String call() throws Exception {
			            TimeUnit.SECONDS.sleep(2); //ģ���ʱ����
			            return Thread.currentThread().getName();
			        }
			    };
			    results.add(service.submit(task)); 
			}
			int count = 0;
			for(int i=0; i<results.size(); i++) {
			    Future<String> taskHolder = results.get(i);
			    if(taskHolder.isDone()) { 
			        String result = taskHolder.get(); //��ȡ���, ����ĳЩ����
			        System.out.println("result: " + result);
			        results.remove(taskHolder);//�������,���������
			        i--;
			        count++; //��ɵ�����ļ�����
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
      * <��> ʹ��ExecutorCompletionService�����첽����
      * 
      * ��������������ò�����ʱ���������
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
						// �����ɶ�����û������, ������; ���򷵻ض����е�����
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
