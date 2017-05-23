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
		 * setUncaughtExceptionHandler()方法传入一个Thread.UncaughtExceptionHandler对象
		 * 只有在抛出异常时候，才会执行
		 */
		t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(t.getName()
						+ " setUncaughtExceptionHandler:[" + e + "]");
			}
		});
		/**
		 * 系统会先检查线程是否有专有的uncaughtException()方法，
		 * 如果没有就在调用defaultUncaughtExceptionHandler
		 * 适用于处理相同的异常
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
