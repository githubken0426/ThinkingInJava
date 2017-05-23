package th.part_21_Concurrence.chapter_03._02Synchronized._04AtomicClass;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 通过原子类AtomicInteger消除了synchronized,程序不会失败
 * @author Administrator
 *
 */
public class AtomicIntegerTest implements Runnable {
	
	private AtomicInteger atomic=new AtomicInteger(0);
	
	public int getValue(){
		return atomic.get();
	}
	
	public void evenIncrement(){
		atomic.addAndGet(2);
	}
	
	@Override
	public void run() {
		while(true){
			evenIncrement();
		}
	}
	
	public static void main(String[] args) throws Exception {
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("程序时间到！");
				System.exit(0);
			}
		}, 5000);
		
		ExecutorService exe=Executors.newCachedThreadPool();
		AtomicIntegerTest test=new AtomicIntegerTest();
		exe.execute(test);
		
		while(true){
			int val=test.getValue();
			System.out.println(val);
			if(val %2!=0){
				System.out.println(val+"不是偶数！");
				System.exit(0);
			}
		}
	}
}
