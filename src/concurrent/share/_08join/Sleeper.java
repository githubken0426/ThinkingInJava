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
			System.out.println(getName()+" try:"+"将沉睡："+duration+"秒");
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
//			e.printStackTrace();
			System.out.println(getName()+" catch:"+" 被中断了 interrupted.isInterrupted():"+isInterrupted());
			return;
		}finally{
			System.out.println(getName()+" finally:"+" has awakened! Sleeper执行完毕！");
		}
	}

}
