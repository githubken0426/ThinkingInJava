package th.part_21_Concurrence.chapter_02._11Join;

import java.util.concurrent.TimeUnit;

public class CustomerMain {

	public static void main(String[] args) throws InterruptedException {
		CustomerThread customer=new CustomerThread();
		CustomerJoiner joiner=new CustomerJoiner(customer);
		TimeUnit.SECONDS.sleep(3);
		joiner.start();
		joiner.join();//�˴�����main�̵߳���join()������main��CustomerThread���ᱻ����
		customer.start();
		System.out.println(Thread.currentThread()+" end Main!");
	}
}
