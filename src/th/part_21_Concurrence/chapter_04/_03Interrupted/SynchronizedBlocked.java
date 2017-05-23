package th.part_21_Concurrence.chapter_04._03Interrupted;


public class SynchronizedBlocked implements Runnable {

	/**
	 * 不能中断正在获取锁或试图操作IO的线程
	 */
	public synchronized void f() {
		while (true) {
			Thread.yield();// 不释放锁，死锁
		}
	}

	public SynchronizedBlocked() {
		new Thread() {
			public void run() {
				f();
			}
		}.start();
	}

	@Override
	public void run() {
		System.out.println("Trying to call f()");
		f();
		/**
		 * f()被阻塞，下面得不到执行
		 */
		System.out.println("Exiting SynchronizedBlocked.run()");

	}

}
