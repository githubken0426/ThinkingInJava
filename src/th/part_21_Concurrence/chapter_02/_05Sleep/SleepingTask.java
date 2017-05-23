package th.part_21_Concurrence.chapter_02._05Sleep;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import th.part_21_Concurrence.chapter_02._01Runnable.LiftOff;

public class SleepingTask extends LiftOff {
	
	public void run(){
		while(countDown-->0){
			System.out.println(status());
			try {
				/**
				 * �쳣���ܿ��̴߳�����main������ֻ���ڱ��ز���
				 */
				//old
				Thread.sleep(1000);
				//new
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ExecutorService exe=Executors.newCachedThreadPool();
		for(int i=0;i<5;i++)
			exe.execute(new SleepingTask());
		exe.shutdown();
	}
}
