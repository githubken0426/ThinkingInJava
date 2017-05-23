package th.part_21_Concurrence.chapter_02._08Daemon;

import java.util.concurrent.TimeUnit;

/**
 * �ػ��߳�(��̨�߳�)
 * 
 * @author Administrator 2016-1-19 ����03:33:19
 * 
 */
public class SimpleDaemon implements Runnable {

	@Override
	public void run() {
		try {
			while (true) {
				TimeUnit.SECONDS.sleep(2);
				System.out.println(Thread.currentThread()+":"+this);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��̨�̻߳�һֱ���У�ֱ���Ǻ�̨�߳̽���
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<10;i++){
			Thread thread=new Thread(new SimpleDaemon());
			thread.setDaemon(true);//������start()֮ǰ����
			thread.start();
		}
		System.out.println("All daemon start!");
		TimeUnit.SECONDS.sleep(5);
	}
}
