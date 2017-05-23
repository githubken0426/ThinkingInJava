package th.part_21_Concurrence.chapter_02._14Exception.other;

import java.util.concurrent.ThreadFactory;

public class LoggerThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread t=new Thread(r);
		System.out.println("LoggerThreadFactory�������̣߳�"+t);
		t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("LoggerThreadFactory�������쳣��"+t.getName()+":"+e);
			}
		});
		return t;
	}

}
