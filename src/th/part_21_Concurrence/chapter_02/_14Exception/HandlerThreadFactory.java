package th.part_21_Concurrence.chapter_02._14Exception;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ThreadFactory;

public class HandlerThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		System.out.println("Created " + t + " by��{" + this.getClass().getSimpleName()+"}");
		/**
		 * setUncaughtExceptionHandler()��������һ��Thread.UncaughtExceptionHandler����
		 * ֻ�����׳��쳣ʱ�򣬲Ż�ִ��
		 */
		t.setUncaughtExceptionHandler(new UncaughtExceptionHandler(){
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("UncaughtExceptionHandler Throwable:[" + e
						+ "] t.getName():[" + t.getName()+"]");
			}
		});
		System.out.println("HandlerThreadFactory en��"+ t.getUncaughtExceptionHandler());
		return t;
	}

	public String toString() {
		return this.getClass().getName();
	}
}
