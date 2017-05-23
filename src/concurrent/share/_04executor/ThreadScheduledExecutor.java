package concurrent.share._04executor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * 
 * ScheduledExecutorService,�ǻ����̳߳���ƵĶ�ʱ������, 
 * ÿ���������񶼻���䵽�̳߳��е�һ���߳�ȥִ��,
 * ��Ҫע��,ֻ�е�������������ʱ��,ScheduledExecutorService�Ż���������һ���߳�,
 * ����ʱ��ScheduledExecutorService���ǳ�����ѯ�����״̬
 * 
 * @return 2017-3-21 ����05:05:47
 */

public class ThreadScheduledExecutor {
	static final SimpleDateFormat format = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public static void main(String[] args) throws InterruptedException {
		ScheduledExecutorService scheduled = Executors
				.newScheduledThreadPool(5);
//		 testAtFixedRate(scheduled);
//		 testAtFixedRateWithException(scheduled);

		 testFixedDelay(scheduled);
		// testSchedule(scheduled);
		System.out.println("����ʱ��" + format.format(new Date()));
//		testSchedule(scheduled, 3);
	}

	/**
	 * ����initialDelay(2��)+period(3��)��ִ�У� �˺���period(3��)��ִ�У���������
	 * ���sleepʱ�����period������sleepʱ���ִ��
	 */
	public static void testAtFixedRate(ScheduledExecutorService scheduled) {
		scheduled.scheduleAtFixedRate(new Runnable() {
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(4);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(format.format(new Date()));
			}
		}, 2, 3, TimeUnit.SECONDS);
	}

	public static void testAtFixedRateWithException(
			ScheduledExecutorService scheduled) {
		// ��ʼִ�к�ʹ����쳣,���ڽ���������
		scheduled.scheduleAtFixedRate(new Runnable() {
			public void run() {
				System.out
						.println("RuntimeException no catch,next time can't run");
				throw new RuntimeException();
			}
		}, 2, 3, TimeUnit.SECONDS);

		// ��Ȼ�׳��������쳣,����������,���ڼ�������
		scheduled.scheduleAtFixedRate(new Runnable() {
			public void run() {
				System.out.println(format.format(new Date()));
				try {
					throw new RuntimeException();
				} catch (Exception e) {
					System.out.println("RuntimeException catched,can run next");
				}
			}
		}, 2, 3, TimeUnit.SECONDS);
	}

	/**
	 * ����initialDelay(2��)��ִ�У� �˺���period(3��)+sleep(1��)��ִ�У���������
	 * @param scheduled
	 * 2017-3-22 ����11:55:42
	 */
	public static void testFixedDelay(ScheduledExecutorService scheduled) {
		scheduled.scheduleWithFixedDelay(new Runnable() {
			public void run() {
				System.out.println(format.format(new Date()));
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, 2, 3, TimeUnit.SECONDS);

	}

	/**
	 * ������ִ���ڸ����ӳٺ����õ�һ��������
	 * @param scheduled
	 * 			ScheduledExecutorServiced����
	 * 2017-3-22 ����11:55:13
	 */
	public static void testSchedule(ScheduledExecutorService scheduled) {
		scheduled.schedule(new Runnable() {
			public void run() {
				System.out.println("The thread can only run once!");
				System.out.println(format.format(new Date()));
			}
		}, 3, TimeUnit.SECONDS);
	}
	/**
	 * ����ScheduleFuture�ӿڣ�ScheduleFuture�̳���Future�ӿ�
	 * @param <T>
	 * @param scheduled
	 * 			ScheduledExecutorServiced����
	 * @param min
	 * 2017-3-22 ����11:52:58
	 */
	public static <T> void testSchedule(ScheduledExecutorService scheduled,
			long min) {
		try {
			ScheduledFuture<T> futrue = scheduled.schedule(new Callable<T>() {
				@SuppressWarnings("unchecked")
				@Override
				public T call() throws Exception {
					return (T) format.format(new Date());
				}

			}, min, TimeUnit.SECONDS);

			System.out.println("�߳�ʱ�䣺" + futrue.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
