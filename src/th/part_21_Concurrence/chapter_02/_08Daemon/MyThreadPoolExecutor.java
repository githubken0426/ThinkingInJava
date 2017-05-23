package th.part_21_Concurrence.chapter_02._08Daemon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor extends AbstractExecutorService AbstractExecutorService
 * implements ExecutorService Executors��ĵײ�ʵ�ֱ���ThreadPoolExecutor
 * 
 * C������int��Ϊ�޷��ź��з������֣��޷��ž���ֻ��ʾ�Ǹ�������
 * һ������32λ�����У�intʹ��32λ�����Ʊ�ʾ��������32��1����2��32�η���1����40���ڡ�
 * �����з���������Java�в��������޷���һ˵�����Զ��������з��ŵģ���
 * ��ʼΪ1��ʾ����������������ֻ������0��ʼ�����31��1����2��31�η���1 ��
 * 2��30�η���1G����Լ1000*1M��Ҳ����10���ڣ��ٳ���2����20������
 * @author Administrator 2016-4-28 ����10:52:44
 * 
 */
public class MyThreadPoolExecutor extends ThreadPoolExecutor {

	public MyThreadPoolExecutor() {
		super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>(), new DaemonThreadFactory());
	}

	public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
				threadFactory);
	}

	/**
	 * ����DaemonThreadPoolExecutor�Ĺ���
	 * �̳���ThreadPoolExecutor��Ҳ�൱����ThreadPoolExecutor�Ĺ���
	 * 
	 * @return
	 */
	// ����һ��ExecutorService����,����һ���̳߳أ��̳߳صĴ�С�������Ҫ������
	// �߳�ִ��������󷵻��̳߳أ���ִ����һ������ʹ��
	public static ExecutorService newCahchedPoolThread() {
		return new MyThreadPoolExecutor(0, Integer.MAX_VALUE, 60L,
				TimeUnit.SECONDS, new SynchronousQueue<Runnable>(),
				new DaemonThreadFactory());
	}

	// ����һ��ExecutorService����,ֻ��һ���߳̿�����ִ���������������һ�������񽫰��Ⱥ�˳��ִ�С�
	public static ExecutorService newSingleThreadExecutor() {
		return new MyThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());
	}

	// ����һ��ExecutorService����,����һ����СΪpoolSize���̳߳أ�
	// ��������������poolSize������ᱻ����һ��queue��˳��ִ��
	public static ExecutorService newFixedThreadPool(int nThreads) {
		return new ThreadPoolExecutor(nThreads, nThreads, 0L,
				TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
	}

	// newSingleThreadScheduledExecutor������һ��ScheduledExecutorService����
	// ���������̳߳ش�СΪ1�����������һ�������񽫰��Ⱥ�˳��ִ�С�
	// newScheduledThreadPool(int poolSize ): ����һ��ScheduledExecutorService����
	// ���������̳߳ش�СΪpoolSize����������������poolSize���������һ��queue��ȴ�ִ��
	
	/**
	 * ���Ժ���
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
//		ScheduledExecutorService scheduled=Executors.newSingleThreadScheduledExecutor();
		ExecutorService exe = MyThreadPoolExecutor.newCahchedPoolThread();
		/**
		 * Executors.callable(Runnable task)��������Runnable������ת����Callable������
		 */
		Callable<Object> cll = Executors.callable(new Runnable() {
			@Override
			public void run() {
				System.out.println("this:" + this);
			}
		});
		List<Future<Object>> list = new ArrayList<Future<Object>>();
		for (int i = 0; i < 5; i++) {
			list.add(exe.submit(cll));
		}

		// exe.execute(new Runnable() {
		// @Override
		// public void run() {
		// for (int i = 0; i < 10; i++)
		// System.out.print(i);
		// System.out.println("\nsleep 3 seconds");
		// }
		// });
		// TimeUnit.SECONDS.sleep(3);
		// Thread t = new Thread() {
		// @Override
		// public void run() {
		// while (true)
		// System.out.println("deamon");
		// }
		// };
		// t.setDaemon(true);
		// exe.execute(t);

		exe.shutdown();

		for (Future<Object> f : list) {
			System.out.println(f);
		}
	}
}
