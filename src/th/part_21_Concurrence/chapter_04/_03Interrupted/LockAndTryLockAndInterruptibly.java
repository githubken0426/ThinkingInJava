package th.part_21_Concurrence.chapter_04._03Interrupted;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAndTryLockAndInterruptibly {
	/**
	 * interrupted()只有在阻塞情况下，才会执行中断操作 如果线程没有阻塞，有可能不会捕获中断异常
	 * 
	 * @author Administrator
	 *
	 */
	static class LockOther implements Runnable {
		private Lock lock = new ReentrantLock();

		@Override
		public void run() {
			String className = Thread.currentThread().getName();
			try {
				lock.lock(); // 拿不到lock就不罢休，不然线程就一直block。
//				lock.lockInterruptibly();// 优先考虑响应中断，不会重新获取锁.此处会立刻跳到catch
//				lock.tryLock(); // tryLock()，马上返回，拿到lock就返回true，不然返回false。
//				lock.tryLock(2, TimeUnit.SECONDS);// 拿不到lock，就等一段时间，超时返回false。

				System.out.println(className.substring(className
						.lastIndexOf(".") + 1) + " Running!");
				TimeUnit.SECONDS.sleep(3);// 此处就是类似线程阻塞

				System.out.println(className.substring(className
						.lastIndexOf(".") + 1) + " Finished!");
			} catch (InterruptedException e) {
				System.out.println(className.substring(className
						.lastIndexOf(".") + 1) + " Interrupted!");
			} finally {
				lock.unlock();
			}
		}

	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new LockOther());
		Thread t2 = new Thread(new LockOther());
		t1.start();
		t2.start();
		t2.interrupt();
	}
}
