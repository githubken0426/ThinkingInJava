package cn.test;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class MyThreadMain {
	public static void main(String[] args) {
		ExecutorService exe=Executors.newCachedThreadPool(new ThreadFactory(){

			@Override
			public Thread newThread(Runnable r) {
				Thread t=new Thread(r);
				t.setUncaughtExceptionHandler(new UncaughtExceptionHandler(){
					@Override
					public void uncaughtException(Thread t, Throwable e) {
						System.out.println("UncaughtExceptionHandler Throwable:[" + e
								+ "],t.getName():[" + t.getName()+"]");
						}
					}
				);
				System.out.println("HandlerThreadFactory en£º"+ t.getUncaughtExceptionHandler());
				return t;
			}
		});
		exe.execute(new MyThread());
	}
}
