package th.part_21_Concurrence.exercise;

import java.util.concurrent.TimeUnit;

import th.part_21_Concurrence.chapter_02._01Runnable.LiftOff;

/**
 * ����LiftOffΪ��̨�̺߳󣬻����cpuʱ��Ƭ�����������(����toString()����)
 * debug��ȫ�����5���߳���
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
