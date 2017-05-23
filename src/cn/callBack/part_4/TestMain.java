package cn.callBack.part_4;

import java.util.concurrent.TimeUnit;

public class TestMain {
	public static void main(String[] args){
		final Student stu=new Student("С��");
		final Seller seller=new Seller("����");
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					System.out.println("��ʼΪ���ż���....");
					TimeUnit.SECONDS.sleep(10);
					System.out.println("��ʱ10��");
					seller.callHelp(15693.00, 25863.0);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		}).start();
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					System.out.println("��ʼΪС������....");
					TimeUnit.SECONDS.sleep(20);
					System.out.println("��ʱ20��");
					stu.callHelp(565.00,3406.03);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
	}
}
