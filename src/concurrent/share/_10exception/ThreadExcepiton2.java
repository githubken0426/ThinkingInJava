package concurrent.share._10exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreadExcepiton2 {
	public static void main(String[] args) {
		ExecutorService exe = Executors
				.newCachedThreadPool(new HanlderThreadFactory());
		exe.execute(new Runnable() {
			@Override
			public void run() {
				throw new RuntimeException();
			}
		});
		exe.shutdown();
	}
}

class HanlderThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable arg0) {
		Thread t = new Thread(arg0);
		/**
		 * setUncaughtExceptionHandler()��������һ��Thread.UncaughtExceptionHandler����
		 * ֻ�����׳��쳣ʱ�򣬲Ż�ִ��
		 */
		t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(t.getName()
						+ " setUncaughtExceptionHandler:[" + e + "]");
			}
		});
		/**
		 * ϵͳ���ȼ���߳��Ƿ���ר�е�uncaughtException()������
		 * ���û�о��ڵ���defaultUncaughtExceptionHandler
		 * �����ڴ�����ͬ���쳣
		 */
		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
					@Override
					public void uncaughtException(Thread t, Throwable e) {
						System.out.println(t.getName()
								+ " setDefaultUncaughtExceptionHandler:[" + e
								+ "]");
					}
				});
		return t;
	}

}
