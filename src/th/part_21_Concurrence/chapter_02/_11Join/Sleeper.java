package th.part_21_Concurrence.chapter_02._11Join;

import java.util.concurrent.TimeUnit;

public class Sleeper extends Thread {
	private int duration;
	
	public Sleeper(String name,int sleepTime){
		super(name);
		this.duration=sleepTime;
		start();
		
	}
	@Override
	public void run() {
		try {
			System.out.println(getName()+"����˯��"+duration+"��");
			TimeUnit.SECONDS.sleep(duration);
//			sleep(duration);
		} catch (InterruptedException e) {
//			e.printStackTrace();
//			System.out.println(getName()+"���ж��ˣ����Բ��ٳ�˯��");
			System.out.println(getName()+" was interrupted.isInterrupted():"+isInterrupted());
			return;
		}finally{
			System.out.println(getName()+" has awakened! Sleeperִ����ϣ�");
		}
	}

}
