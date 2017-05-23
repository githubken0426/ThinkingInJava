package th.part_21_Concurrence.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Exercise_20 {
	static class LiftOff implements Runnable {
		protected int countDown=5000;
		private static int taskCount=0;
		private final int id=taskCount++;
		
		public LiftOff(){}
		
		public LiftOff(int countDown){
			this.countDown=countDown;
		}
		public String status(){
			return Thread.currentThread()+":#"+ id+"("+(countDown>0?countDown:"LiftOff")+"),";
		}
		@Override
		public void run() {
			while (countDown-->0) {
				if(Thread.currentThread().isInterrupted()){
					System.out.println("Interrputed by "+id);
					return;
				}
				System.out.println(status());
				/**
				 * yield():对线程调度器的一种建议:选择性的，
				 * 暂停当前线程，由cpu决定执行其他线程(包括自身线程)，
				 * 它只能让同优先级的线程有执行的机会
				 */
				Thread.yield();
			}
		}
	}
	
	public static void main(String[] args) {
		ExecutorService exe=Executors.newCachedThreadPool();
		for(int i =0;i<5;i++){
			exe.execute(new LiftOff());
		}
		Thread.yield();
		exe.shutdownNow();
	}
}
