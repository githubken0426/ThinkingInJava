package concurrent.share._04executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor extends AbstractExecutorService 
 * AbstractExecutorService implements ExecutorService 
 * Executors��ĵײ�ʵ�ֱ���ThreadPoolExecutor
 * 
 * ExecutorService��submit()��execute()��������
 * submit()�з���ֵ������Callable<T>,Runnable,T�Ȳ���,ͨ����Futureһ��ʹ��
 * execute()û�з���ֵ��ֻ����Runnable
 * 
 * @author Administrator 2016-4-28 ����10:52:44
 * 
 */
public class MyThreadPoolExecutor extends ThreadPoolExecutor {

	/**
	 * 1.corePoolSize:�����߳���,�̳߳�ά���̵߳���������
	 * 
	 * 2.maximumPoolSize:�̳߳�ά���̵߳��������
	 * 
	 * 3.keepAliveTime:���߳̿���ʱ��ﵽkeepAliveTime��
	 * ���̻߳��˳���ֱ���߳���������corePoolSize��
	 * �����߳���allowCoreThreadTimeout������Ϊtrueʱ�ᳬʱ�˳���Ĭ������²����˳�
	 * 
	 * 4.unit:�̳߳�ά���߳�������Ŀ���ʱ��ĵ�λ
	 * 
	 * 5.workQueue:�̳߳���ʹ�õĻ������ 
	 * 
	 * 6.handler���̳߳ضԾܾ�����Ĵ������
	 * 
	 * 1.1 �����ʱ�̳߳��е�����С��corePoolSize��
	 * ��ʹ�̳߳��е��̶߳����ڿ���״̬��ҲҪ�����µ��߳���������ӵ�����
	 * 
	 * 1.2 �����ʱ�̳߳��е��������� corePoolSize��
	 * ���ǻ������ workQueueδ������ô���񱻷��뻺�����.
	 * 
	 * 1.3 �����ʱ�̳߳��е���������corePoolSize���������workQueue����
	 * �����̳߳��е�����С��maximumPoolSize�����µ��߳���������ӵ�����.
	 * 
	 * 1.4 �����ʱ�̳߳��е���������corePoolSize���������workQueue����
	 * �����̳߳��е���������maximumPoolSize�����ѳ����̳߳صĴ���������
	 * �̳߳ػ�ܾ�����������׳��쳣,����ͨ��handler��ָ���Ĳ�����������쳣
	 * 
	 */
//	ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, 
//					long keepAliveTime, TimeUnit unit, 
//					BlockingQueue<Runnable> workQueue, 
//					ThreadFactory threadFactory,
//					RejectedExecutionHandler handler) 
	
	/**
	 * ��SynchronousQueue�����ܶ��ڸ�BlockingQueue��Щİ������˵����QUEUE�У�
	 * ÿ�������������ȴ���һ���̵߳Ķ�Ӧ�Ƴ�������
	 * ���磬�������һ��Ԫ�أ���������������볢��������������ֱ����һ���߳�ȡ��һ��Ԫ��
	 */
	public MyThreadPoolExecutor() {
		super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>(), new DeamonThreadFactory());
	}

	public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		allowCoreThreadTimeOut(true);
	}

	public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
				threadFactory);
	}
	
	/**
	 * 1��
	 * ����һ���ɻ�����̳߳ء�����߳��п��õ������ã����򣬴���һ�����̲߳���ӵ����С�
	 * ��ֹ���ӻ������Ƴ���Щ���� 60 ����δ��ʹ�õ��߳�
	 * @return
	 * 2017-3-21 ����05:00:01
	 */
	public static ExecutorService newCahchedPoolThread() {
		return new MyThreadPoolExecutor(0, Integer.MAX_VALUE, 60L,
				TimeUnit.SECONDS, new SynchronousQueue<Runnable>(),
				new DeamonThreadFactory());
	}

	/**
	 *  2��
	 *  ����ֻ��һ���߳̿�����ִ������
	 *  ���������һ��������ᱻ����һ��LinkedBlockingQueue��˳��ִ��
	 * @return
	 * 2017-3-21 ����05:01:32
	 */
	public static ExecutorService newSingleThreadExecutor() {
		return new MyThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());
	}

	/**
	 *  3��
	 *  ����һ����СΪnThreads���̳߳أ�
	 *  ��������������nThreads������ᱻ����һ��LinkedBlockingQueue��˳��ִ��
	 * @param nThreads
	 * @return
	 * 2017-3-21 ����05:00:33
	 */
	public static ExecutorService newFixedThreadPool(int nThreads) {
		return new ThreadPoolExecutor(nThreads, nThreads, 0L,
				TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
	}
	
	/**
	 * ���Ժ���
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args){
//		ExecutorService exe = MyThreadPoolExecutor.newCahchedPoolThread();
		/**
		 * Executors.callable(Runnable task)��������Runnable������ת����Callable������
		 */
		/*try {
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
			for (Future<Object> f : list) {
				System.out.println(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			exe.shutdown();
		}*/
		testThreadPoolExecutor();
	}
	
	public static void testThreadPoolExecutor(){
		int corePoolSize=5, maximumPoolSize=5;
		long keepAliveTime=1l;
		TimeUnit unit=TimeUnit.SECONDS;
		LinkedBlockingQueue<Runnable> workQueue=new LinkedBlockingQueue<Runnable>();
		ExecutorService exe=new ThreadPoolExecutor
			(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		for(int i=0;i<5;i++){
			final int  a=i;
			exe.execute(new Runnable(){
				@Override
				public void run() {
					Thread.currentThread().setName(a+"");
					System.out.println(Thread.currentThread()+"_"+a);
				}
			});
		}
		exe.shutdown();
	}
}
