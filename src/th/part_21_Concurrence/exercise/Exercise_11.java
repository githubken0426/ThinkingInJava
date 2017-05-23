package th.part_21_Concurrence.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise_11{
	static abstract class DGenerator{
		private volatile boolean cancel=false;
		public void cancel(){
			cancel=true;
		}
		public boolean isCancel(){
			return cancel;
		}
		abstract int next();
	}
	static class EGenerator extends DGenerator{
		private int currentVal=0;
		@Override
		synchronized int next() {//synchronized¹Ø¼ü×Ö
			++currentVal;
			Thread.yield();
			++currentVal;
			return currentVal;
		}
		
	}
	 static class Thread1 implements Runnable{
		private DGenerator g;
		
		public Thread1(DGenerator g){
			this.g=g;
		}
		@Override
		public  void run() {
			while(!g.isCancel()){
				int val=g.next();
				System.out.println(val);
				if(val%2!=0){
					System.out.println(val+" ÊÇÆæÊý£¡");
					g.cancel();
				}
			}
		}
		public static void test(EGenerator g,int count) {
			System.out.println("Press Contorl-C to exit!");
			ExecutorService exe=Executors.newCachedThreadPool();
			for(int i=0;i<count;i++)
				exe.execute(new Thread1(g));
			exe.shutdown();
		}
		
		public static void test(EGenerator g){
			test(g,10);
		}
	}
	
	public static void main(String[] args) {
		Thread1.test(new EGenerator());
	}
	
}
