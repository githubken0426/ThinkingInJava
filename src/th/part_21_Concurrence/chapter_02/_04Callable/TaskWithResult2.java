package th.part_21_Concurrence.chapter_02._04Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
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
			
			FutureTask<String> future = new FutureTask<String>(
					new TaskWithResult2<String>("����ֵ"));
			exe.submit(future);
//			TimeUnit.SECONDS.sleep(4);
			System.out.println("future.isDone()="+future.isDone());
			if(future.isDone())
				System.out.println("future.get():"+future.get());
			System.out.println("method futureTask()");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}finally{
			exe.shutdown();
		}
	}
	
	/**
	 * CompletionService�����Դ�һ���̰߳�ȫ�����Ա������û����ⴴ����
	 * ���ṩ��2�ַ��������Ա���ȡ�������
	 * poll()�Ƿ������ģ���Ŀǰ�޽��������һ��null���̼߳������в�������
	 * take()�������ģ�����ǰ�޽�������߳�������ֱ������һ���������ȡ�����أ��̲߳ż������С�
	 * @param exe
	 * 2017-3-21 ����03:35:41
	 */
	static void completionService(ExecutorService exe){
		try {
			CompletionService<String> cs = new ExecutorCompletionService<String>(exe);
			cs.submit(new TaskWithResult2<String>("����ֵ"));
//			System.out.println(cs.take().isDone());
			
			System.out.println("future.get():"+cs.take().get());
			System.out.println("method futureTask()");
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
//		futureTask(exe);
		completionService(exe);
	}
}
