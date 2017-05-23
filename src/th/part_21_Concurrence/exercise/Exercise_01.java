package th.part_21_Concurrence.exercise;

/**
 * 联系1
 * @author Administrator
 * 2016-1-18 上午11:39:35
 *
 */
public class Exercise_01 implements Runnable{
	private static int taskCount;
	private final int id=taskCount++;
	public Exercise_01(){
		System.out.println(Thread.currentThread().getName()+"，Exercise_01:"+id);
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+":"+id);
		Thread.yield();
		System.out.println(Thread.currentThread().getName()+":"+id);
		Thread.yield();
		System.out.println(Thread.currentThread().getName()+":"+id);
		Thread.yield();
	}
	
	/**
	 *  1） start：用start方法来启动线程，真正实现了多线程运行，
	 *  这时无需等待run方法体,代码执行完毕而直接继续执行下面的代码。
	 *  通过调用Thread类的start()方法来启动一个线程，
	 *  这时此线程处于就绪（可运行）状态，并没有运行，一旦得到cpu时间片，
	 *  就开始执行run()方法，这里方法 run()称为线程体，它包含了要执行的这个线程的内容，
	 *  Run方法运行结束，此线程随即终止。
	 *  
	 *  2） run：run()方法只是类的一个普通方法而已，如果直接调用Run方法，
	 *  程序中依然只有主线程这一个线程，其程序执行路径还是只有一条，还是要顺序执行，
	 *  还是要等待run方法体执行完毕后才可继续执行下面的代码，这样就没有达到写线程的目的。
	 *  
	 *  总结：调用start方法方可启动线程，而run方法只是thread的一个普通方法调用，还是在主线程里执行。
	 *  start()方法启动线程将自动调用 run()方法，这是由jvm的内存机制规定的。
	 *  并且run()方法必须是public访问权限，返回值类型为void.
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=1;i<=3;i++){
			new Thread(new Exercise_01()).start();
//			new Exercise_01().run();
		}
		
	}

}
