package concurrent.share._01runnable;


/**
 * 三 定义任务
 * @author Administrator
 * 2016-1-18 下午01:48:03
 * 具有可论证的确定性，实际上具有不可确定性
 */

public class LiftOff implements Runnable {
	protected int countDown=3;
	private static int taskCount=0;
	private final int id=taskCount++;
	
	public LiftOff(){}
	public LiftOff(int countDown){
		this.countDown=countDown;
	}
	public String status(){
		return Thread.currentThread()+":#id="+ id+",("+(countDown>0?countDown:"LiftOff")+"),";
	}
	@Override
	public void run() {
		while (countDown-->0) {
			System.out.println(status());
			/**
			 * yield():对线程调度器的一种建议:选择性的，
			 * 暂停当前线程，由cpu决定执行其他线程(包括自身线程)，
			 * 它只能让同优先级的线程有执行的机会
			 */
			Thread.yield();
		}
	}
	
	public static void main(String[] args) {
		LiftOff lift=new LiftOff();
		lift.run();
		System.out.println("I an main!\n");
	}
}
