package th.part_21_Concurrence.chapter_04._03Interrupted.mutex_block;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockedMutex {
	private Lock lock=new ReentrantLock();
	
	public BlockedMutex(){
		/**
		 * 可以证明在ReentrantLock对象上立刻获得一个被阻塞的任务
		 * f()方法中调用也一样
		 */
		lock.lock();
	}
	
	public void f(){
		try {
			/**
			 * lock方法默认处理了中断请求，一旦监测到中断状态，则中断当前线程；
			 * 并且Lock方法在阻塞的时候是不响应中断的。 
			 * lock获取锁过程中，忽略了中断，在成功获取锁之后，再根据中断标识处理中断
			 * 
			 * 而lockInterruptibly()则直接抛出中断异常，由上层调用者区去处理中断
			 */
			lock.lockInterruptibly();
//			lock.lock();
			System.out.println("Lock by f()");
		} catch (Exception e) {
			System.out.println("InterruptedException Interrupted from f()");
		}
	}
	
	static class Block2 implements Runnable{
		BlockedMutex b=new BlockedMutex();
		@Override
		public void run() {
			System.out.println("Wwait for BlockedMutes");
			b.f();
			System.out.println("break out of blocked call");
		}
		
	}
	
	/**
	 * interrupt()方法可以打断被互斥所阻塞的调用
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread t=new Thread(new Block2());
		t.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("执行 t.interrupt()");
		t.interrupt();
	}
}
