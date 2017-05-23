package th.part_21_Concurrence.chapter_04._03Interrupted;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Interrupting {
	private static ExecutorService exe =Executors.newCachedThreadPool();
	
	/**
	 * 调用exe.shutdownNow(),将发送一个interrupted()调用给它启动的线程
	 * @param r
	 * @throws InterruptedException
	 */
	static void test(Runnable r)throws InterruptedException{
		Future<?> f=exe.submit(r);
		TimeUnit.MILLISECONDS.sleep(100);
		String className=r.getClass().getName();
		System.out.println(className.substring(className.lastIndexOf(".")+1)+" was raady to Interrupt!");
		/**
		 * cancel()可以用来中断某个线程
		 */
		f.cancel(true);
		System.out.println("Interrupt send to "+className.substring(className.lastIndexOf(".")+1));
	}
	
	/**
	 * 不能中断试图获取synchronized或者I/O操作的线程
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
//		test(new SleepBlocked());
//		test(new IOBlocked(System.in));
		test(new SynchronizedBlocked());
		TimeUnit.SECONDS.sleep(10);
		System.exit(0);
	}
}
