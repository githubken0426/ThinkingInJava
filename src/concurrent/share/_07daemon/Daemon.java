package concurrent.share._07daemon;

import java.util.concurrent.TimeUnit;

public class Daemon implements Runnable {
	@Override
	public void run() {
		try {
			while(true){
				TimeUnit.SECONDS.sleep(1);
				System.out.println(Thread.currentThread()+"_"+this);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("sleep interrupted"+e);
		}
	}
	
	/**
	 * main线程结束也就杀死了后台线程
	 * @param args
	 * @throws InterruptedException
	 * 2017-3-22 下午03:48:21
	 */
	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<5;i++){
			Thread d=new Thread(new Daemon());
			d.setDaemon(true);//设置为后台线程
			d.start();
		}
		System.out.println("all deamons start!");
		TimeUnit.SECONDS.sleep(5);
	}
}
