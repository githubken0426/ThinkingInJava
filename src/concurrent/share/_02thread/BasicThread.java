package concurrent.share._02thread;

import concurrent.share._01runnable.LiftOff;



/**
 *  start：用start方法来启动线程，真正实现了多线程运行，
 *  这时无需等待run的方法体，此线程处于就绪（可运行）状态，并没有运行，一旦得到cpu时间片，
 *  就开始执行run()方法，这里方法 run()称为线程体，它包含了要执行的这个线程的内容，
 *  Run方法运行结束，此线程随即终止。
 *  
 *  总结：调用start方法方可启动线程，start()方法启动线程将自动调用 run()方法，这是由jvm的内存机制规定的。
 *  
 *  实现接口好处：
 *  1）避免继承的局限性：一个类可以继承多个接口。
　　2）更加适合于资源的共享
 *  
 * 	@author Administrator
 *  2016-1-19 上午09:05:17
 */
public class BasicThread {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new LiftOff());
		t.start();
		new MyThread().start();
		System.out.println(Thread.currentThread()+":Wait for LiftOff");
	}
}


class MyThread extends Thread{
	@Override
	public void run() {
		Thread.currentThread().setName("MyThread");
		System.out.println(Thread.currentThread()+":This is MyThread");
	}
	
}