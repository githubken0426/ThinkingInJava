package th.part_21_Concurrence.exercise;

import java.util.concurrent.TimeUnit;

import th.part_21_Concurrence.chapter_02._01Runnable.LiftOff;

/**
 * 设置LiftOff为后台线程后，会根据cpu时间片，不规律输出(调用toString()方法)
 * debug会全部输出5组线程组
 * @author Administrator
 *
 */
public class Exercise_08 {
	public static void main(String[] args) {
		
		for(int i=0;i<5;i++){
			Thread t=new Thread(new LiftOff());
			t.setDaemon(true);
			t.start();
		}
		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Waiting For LlftOff!");
	}
}
