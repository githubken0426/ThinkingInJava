package concurrent.share._03callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;


/**
 * ʹ��FutureTask
 * 
 * @author ken
 * @param <V>
 * 2017-3-21 ����02:31:47
 */

public class TaskWithResult2<V> implements Callable<V> {
	private String id;
	public TaskWithResult2() {}
	public TaskWithResult2(String id) {
		this.id = id;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public V call() throws Exception {
		for (int i = 1; i <= 3; i++) {
			System.out.println("task sleep "+i + "��");
			TimeUnit.SECONDS.sleep(1);
		}
		return (V) (Thread.currentThread() + ":" + id);
	}
	/**
	 *  
	 * ������isDone()�������Future�Ƿ��Ѿ����; 
	 * Ҳ��ֱ�ӵ���get()��get()�ᱻ����ֱ�����񷵻ؽ��
	 * 
	 * @param exe
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * 2017-3-21 ����01:57:49
	 */
	static void futureTask(ExecutorService exe){
		try {
//			public class FutureTask implements RunnableFuture 
//			public interface RunnableFuture extends Runnable,Future
			System.out.println("method futureTask()");
			FutureTask<String> future = new FutureTask<String>(
					new TaskWithResult2<String>("����ֵ"));
			exe.submit(future);
			TimeUnit.SECONDS.sleep(4);
			System.out.println("future.isDone()="+future.isDone());
			if(future.isDone())
				System.out.println("future.get():"+future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}finally{
			exe.shutdown();
		}
	}
	
	
	public static void main(String[] args) {
		ExecutorService exe = Executors.newCachedThreadPool();
		futureTask(exe);
	}
}
