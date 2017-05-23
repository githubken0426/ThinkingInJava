package concurrent.share._05sleep;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepTask implements Runnable {
	/**
	 * �쳣���ܿ��̴߳�����������Ҫ�ڱ��߳��ڴ���
	 */
	@Override
	public void run() {
		try {
			for (int i = 1; i <= 10; i++) {
//				Thread.sleep(1000,1000);
				TimeUnit.SECONDS.sleep(1);
				System.out.println(i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ExecutorService exe=Executors.newCachedThreadPool();
		exe.execute(new SleepTask());
		exe.shutdown();
	}
}
