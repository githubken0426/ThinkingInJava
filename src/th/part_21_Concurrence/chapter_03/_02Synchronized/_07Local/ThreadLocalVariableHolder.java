package th.part_21_Concurrence.chapter_03._02Synchronized._07Local;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalVariableHolder {
	
	/**
	 * increment()和get()都不是synchronized，ThreadLocal避免了线程间的竞争
	 */
	private static ThreadLocal<Integer> value=new ThreadLocal<Integer>(){
		private Random rand=new Random(47);
		
		protected synchronized Integer initialValue(){
			return rand.nextInt(10000);
		}
	};
	
	public static void increment(){
		value.set(value.get()+1);
	}
	
	public static int get(){
		return value.get();
	}
	
	public static void main(String[] args) {
		ExecutorService exe=Executors.newCachedThreadPool();
		for(int i =0;i<5;i++){
			exe.execute(new Accessor(i));
		}
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		exe.shutdown();
	}
}
