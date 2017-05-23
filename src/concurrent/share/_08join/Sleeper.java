package concurrent.share._08join;

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
			System.out.println(getName()+" try:"+"����˯��"+duration+"��");
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
//			e.printStackTrace();
			System.out.println(getName()+" catch:"+" ���ж��� interrupted.isInterrupted():"+isInterrupted());
			return;
		}finally{
			System.out.println(getName()+" finally:"+" has awakened! Sleeperִ����ϣ�");
		}
	}

}
