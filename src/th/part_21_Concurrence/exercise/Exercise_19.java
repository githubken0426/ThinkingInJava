package th.part_21_Concurrence.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Exercise_19 {
	static class Count {
		private int count=0;
		private Random random=new Random(47);
		
		public synchronized int incrment(){
			int temp=count;
			if(random.nextBoolean())
				Thread.yield();
			return (count=++temp);
		}
		
		public synchronized int value(){
			return count;
		}
	}
	
	static class Entrance implements Runnable{
		private static Count count=new Count();
		private static List<Entrance> list=new ArrayList<Entrance>();
		private int number=0;
		
		//不需要synchronized
		private final int id;
		private static volatile boolean canceled=false;
		
		//一个原子表达式
		public static void cancel(){
			canceled=true;
		}
		
		public Entrance(int id){
			this.id=id;
			list.add(this);
		}
		
		@Override
		public void run() {
			while(!canceled){
				synchronized(this){
					++number;
				}
				System.out.println(this+" ，总计:"+count.incrment());
				try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					System.out.println(this+"was Interrupted");
				}
			}
			System.out.println("Stopping "+this);
		}

		public synchronized int getValue(){
			return number;	
		}
		
		public String toString(){
			return "Entrance_"+id+"第:"+getValue()+"人";
		}
		
		public static int getTotalCount(){
			return count.value();
		}
		
		public static int sumEntrances(){
			int sum=0;
			for (Entrance entrance : list) {
				sum+=entrance.getValue();
			}
			return sum;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService exe=Executors.newCachedThreadPool();
		for(int i=0;i<5;i++)
			exe.execute(new Entrance(i));
		TimeUnit.SECONDS.sleep(1);
		Entrance.cancel();
		exe.shutdownNow();
		/**
		 * awaitTermination等待每个任务结束
		 * 如果所有的任务都在超时之前结束返回true，否则返回false
		 * 虽然终止了任务，但是Entrance式存储在static list中的，所以还会输出 
		 */
		if(!exe.awaitTermination(250,TimeUnit.MILLISECONDS)){
			System.out.println("Some Task were not terminlated");
		}
		System.out.println("Total:"+Entrance.getTotalCount());
		System.out.println("Sum:"+Entrance.sumEntrances());
	}
}
