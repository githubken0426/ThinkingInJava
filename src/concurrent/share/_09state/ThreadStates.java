package concurrent.share._09state;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ThreadStates {
	private static Thread thread;
	private static DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//NEW
	static void threadNew() {
		thread = new Thread();
		System.out.println(thread.getState());
	}
	//RUNNABLE
	static void threadRunnable() {
		thread.start();
		System.out.println(thread.getState());
	}
	//WAITING
	static void threadWaiting() throws InterruptedException {
		thread = new Thread() {
			private Object lock = new Object();
			public void run() {
				synchronized (lock) {
					try {
						lock.wait();
					} catch (InterruptedException interruptedEx) {
						interruptedEx.printStackTrace();
					}
				}
			}
		};
		thread.start();
		// here hold a sec,make sure this thread gets the monitor.
		TimeUnit.SECONDS.sleep(3);
		System.out.println(thread.getState());
	}
	// TIMED_WAITING
	static void threadTimedWaiting() throws InterruptedException {
		thread = new Thread() {
			private Object lock = new Object();

			public void run() {
				synchronized (lock) {
					try {
						TimeUnit.SECONDS.sleep(5);
//						lock.wait(50000);
					} catch (InterruptedException interruptedEx) {
						interruptedEx.printStackTrace();
					}
				}
			}
		};
		thread.start();

		// here hold a sec,make sure this thread gets the monitor.
		TimeUnit.SECONDS.sleep(3);
		System.out.println(thread.getState());
	}
	//BLOCKED
	static void threadBlock()
			throws InterruptedException {
		final Object sharedLock = new Object();

		Thread anotherThreadHoldsTheLockForAWhile = new Thread() {
			public void run() {
				synchronized (sharedLock) {
					System.out.println(getName() + 
							" holding lock "+format.format(new Date()));
					try {
						TimeUnit.SECONDS.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		anotherThreadHoldsTheLockForAWhile.start();
		// holds a sec to ensure the thread anotherThreadHoldsTheLockForEver got
		// the sharedLock first
		TimeUnit.SECONDS.sleep(1);
		thread = new Thread() {
			public void run() {
				synchronized (sharedLock) {
					System.out.println(getName() + 
							" Got the lock "+format.format(new Date()));
				}
			}
		};
		thread.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println(thread.getState());
	}
	//TERMINATED
	static void threadTerminated()
			throws InterruptedException {
		thread=new Thread();
		thread.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println(thread.getState());
	}

	public static void main(String[] args) throws InterruptedException {
		threadNew();
		threadRunnable();
		threadWaiting();
		threadTimedWaiting();
		threadBlock();
		threadTerminated();
	}
}
