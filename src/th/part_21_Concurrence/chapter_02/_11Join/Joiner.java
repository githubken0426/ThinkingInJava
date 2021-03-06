package th.part_21_Concurrence.chapter_02._11Join;

public class Joiner extends Thread {
	private Sleeper sleeper;
	
	public Joiner(String name,Sleeper sleeper){
		super(name);
		this.sleeper=sleeper;
		start();
	}
	
	/**
	 * 线程里面调用另一线程join方法时，表示将本线程阻塞
	 * 直至另一线程终止时(执行完毕、从阻塞中醒来、被中断等）再执行 
	 * 
	 * 调用interrupt方法，当前线程不在被挂起，和另一线程一起结束
	 * 
	 * 在另外一个线程上(此处为Joiner)调用interrupt方法，将会给此线程一个标志，表示中断状态
	 * 但是被异常捕获时候，会清除这个标志，所以异常捕获的一直为false
	 */
	public void run(){
		try {
			System.out.println("Joiner执行sleeper.join()！");
			sleeper.join();
//			System.out.println(sleeper.getName()+" sleeper.join()执行完毕！");
			System.out.println("Joiner继续执行其他方法！");
		} catch (InterruptedException e) {
//			e.printStackTrace();
			System.out.println("Joiner:"+this.getName()+" Interrputed");
		}
	}
}
