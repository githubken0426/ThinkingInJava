package concurrent.share._07daemon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import concurrent.share._04executor.DeamonThreadFactory;


/**
 * 通过工厂类创建后台线程
 * 
 * @author ken
 * 2017-3-22 下午03:50:32
 */
public class DaemonFromThreadFactory {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exe=Executors.newCachedThreadPool(new DeamonThreadFactory());
		exe.execute(new Task());
		TimeUnit.SECONDS.sleep(5);
		exe.shutdown();
	}
}

class Task implements Runnable{

	@Override
	public void run() {
		try {
			while(true){
				System.out.println(Thread.currentThread()+"_"+this);
				TimeUnit.SECONDS.sleep(1);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("sleep interrupted"+e);
		}
	}
	
}