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
 * ʹ��Future
 * �߳��������첽����ģ�ͣ������㲻����ֱ�Ӵӱ���߳��еõ���������ֵ��
 * ��ʱ��Future�ͳ����ˡ�Futrue���Լ���Ŀ���̵߳���call�������
 * �������Future��get()�����Ի�ý��ʱ����ǰ�߳̾Ϳ�ʼ������ֱ��call�����������ؽ��
 * 
 * Future�ӿ���������5�������� 
 * cancel(boolean mayInterruptIfRunning)��������ȡ������.
 * 
 * ���ȡ������ɹ��򷵻�true�����ȡ������ʧ���򷵻�false��
 * ����mayInterruptIfRunning��ʾ�Ƿ�����ȡ������ִ��ȴû��ִ����ϵ�����
 * �������true�����ʾ����ȡ������ִ�й����е�����
 * ��������Ѿ���ɣ�������mayInterruptIfRunningΪtrue����false���˷����϶�����false,�����ȡ���Ѿ���ɵ�����᷵��false��
 * �����������ִ�У���mayInterruptIfRunning����Ϊtrue���򷵻�true����mayInterruptIfRunning����Ϊfalse,�򷵻�false��
 * �������û��ִ��,������mayInterruptIfRunningΪtrue����false���϶�����true��
 * 
 * isCancelled������ʾ�����Ƿ�ȡ���ɹ�������������������ǰ��ȡ���ɹ����򷵻� true��
 * isDone������ʾ�����Ƿ��Ѿ���ɣ���������ɣ��򷵻�true�� 
 * get()����������ȡִ�н������������������������һֱ�ȵ�����ִ����ϲŷ��أ�
 * 
 * get(long timeout, TimeUnit unit)������ȡִ�н��,�����ָ��ʱ���ڣ���û��ȡ���������ֱ�ӷ���null��
 * 
 * @author ken
 * @param <V>
 *            2017-3-21 ����02:32:01
 */
public class TaskWithResult<V> implements Callable<V> {
	
	private int id;
	public TaskWithResult(int id) {
		this.id = id;
	}

	// ��run()���������ǣ�call���������׳��쳣
	@SuppressWarnings("unchecked")
	@Override
	public V call() throws Exception {
		return (V) (Thread.currentThread() + ":" + id);
	}
	
	static void futureList(ExecutorService exe){
		try {
			List<Future<?>> list = new ArrayList<Future<?>>();
			for (int i = 0; i < 5; i++) {
				TimeUnit.SECONDS.sleep(2);// ģ��ִ������������
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
	 * submit()��������Future����
	 * 
	 * ������һ���ܺ�ʱ�ķ���ֵ��Ҫ���㣬�����������ֵ����������Ҫ�Ļ���
	 * ��ô�Ϳ�����һ���߳�ȥ���㷵��ֵ������ǰ�߳���ʹ���������ֵ֮ǰ�����������Ĳ�����
	 * �ȵ���Ҫ�������ֵʱ����ͨ��Future�õ�.
	 * @param exe
	 * 2017-3-21 ����02:34:04
	 */
	public static void main(String[] args) {
		ExecutorService exe = Executors.newCachedThreadPool();
		futureList(exe);
	}
}
