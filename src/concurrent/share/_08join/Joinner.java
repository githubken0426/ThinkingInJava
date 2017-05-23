package concurrent.share._08join;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Joinner implements Runnable {
	private static DateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	@Override
	public void run() {
		System.out.println(Thread.currentThread()+" Begin:"+format.format(new Date()));
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread()+ " End:"+format.format(new Date()));
	}
	/**
	 * join()阻塞当前线程，直到join的线程结束
	 * @param args
	 * @throws InterruptedException
	 * 2017-3-22 下午04:50:27
	 */
	public static void main(String[] args) throws InterruptedException {
		System.out.printf(Thread.currentThread()+" Begin:%s\n",format.format(new Date()));
		Thread t=new Thread(new Joinner(),"joinner");
		t.start();
		t.join();
		System.out.printf(Thread.currentThread()+" End:%s\n",format.format(new Date()));
	}

}
