package th.part_21_Concurrence.chapter_02._04Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


/**
 * ʹ��FutureTask
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
	 * CompletionService�����Դ�һ���̰߳�ȫ�����Ա������û����ⴴ����
	 * ���ṩ��2�ַ��������Ա���ȡ�������
	 * poll()�Ƿ������ģ���Ŀǰ�޽��������һ��null���̼߳������в�������
	 * take()�������ģ�����ǰ�޽�������߳�������ֱ������һ�������
	 * ��ȡ���󷵻أ��̲߳ż������С�
	 * @param exe
	 * 2017-3-21 ����03:35:41
	 */
	static void completionService(ExecutorService exe){
		try {
			System.out.println("method completionService()");
			CompletionService<String> cs = new ExecutorCompletionService<String>(exe);
			
			for(int i=0;i<3;i++){
				cs.submit(new TaskWithResult3<String>(i+""));
				Future<String> future = cs.poll();
				if(future ==null)
					System.out.println("������δ��ɣ�");
				else
					System.out.println("future.get():"+future.get());
				TimeUnit.SECONDS.sleep(3);
			}
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
		completionService(exe);
	}
}
