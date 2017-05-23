package th.part_21_Concurrence.chapter_02._08Daemon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonFromFactory implements Runnable {

	@Override
	public void run() {
		try {
			while(true){
				TimeUnit.SECONDS.sleep(3);
				System.out.println(Thread.currentThread()+":"+this);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		/**
		 * ����һ����̨�̹߳����ࡣ
		 * newCachedThreadPool(ThreadFactory f)�������أ��������µ��߳�
		 * ���DaemonThreadPoolExecutor
		 */
		ExecutorService exe=Executors.newCachedThreadPool(new DaemonThreadFactory());
		for(int i=0;i<10;i++)
			exe.execute(new DaemonFromFactory());
		System.out.println("All daemon start!");
		TimeUnit.SECONDS.sleep(100);
	}
}
