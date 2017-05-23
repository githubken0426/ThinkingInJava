package th.part_21_Concurrence.chapter_02._09ChangeCode;

import java.util.concurrent.TimeUnit;

/**
 * 通过匿名接口实现
 * @author Administrator
 *
 */
public class InnerRunnable2 {
	private int countDown=5;
	private Thread t;
	
	public InnerRunnable2(String name){
		t=new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					while(true){
						System.out.println(this);
						if(--countDown==0)return;
						TimeUnit.SECONDS.sleep(2);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.out.println("Interrupter");
				}
			}
			
			public String toString(){
				return Thread.currentThread()+":"+countDown;
			}
		},name);
		t.start();
	}
}
