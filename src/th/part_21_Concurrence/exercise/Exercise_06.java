package th.part_21_Concurrence.exercise;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Á·Ï°6
 * @author Administrator
 * 2016-1-19 ÏÂÎç01:24:15
 *
 */
public class Exercise_06 implements Runnable {
	private Random random=new Random();
	private final int timeout=random.nextInt(10);
	
	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Sleep Time:"+timeout);
	}
	
	public static void main(String[] args) {
		ExecutorService exe=Executors.newCachedThreadPool();
		for(int i=0;i<5;i++)
			exe.execute(new Exercise_06());
		exe.shutdown();
	}
}
