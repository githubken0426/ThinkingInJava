package concurrent.share._06priority;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimplePriority implements Runnable{
	private int countDown=3;
	private volatile double d;//no optimization(编译器无优化)
	private int priority;
	private String name;
	
	public SimplePriority(int priority,String name){
		this.priority=priority;
		this.name=name;
	}
	
	public String toString(){
		return Thread.currentThread()+":"+countDown;
	}
	
	@Override
	public void run() {
		Thread.currentThread().setName(name);
		Thread.currentThread().setPriority(priority);
		while(true){
			for(int i=0;i<10000000;i++){
				d+=(Math.PI+Math.E)/(double)i;
				if(i%100==0)
					Thread.yield();
			}
			System.out.println(this);
			if(--countDown==0)return;
		}
	}
	
	public static void main(String[] args) {
		ExecutorService exe=Executors.newCachedThreadPool();
		for(int i=0;i<5;i++)
			exe.execute(new SimplePriority(Thread.MIN_PRIORITY,"min_"+i));
		/**
		 * 注意：优先级是在run()开头处设定的，在构造器设置没有任何好处
		 * 因为Executor还没有开始执行任务
		 */
		exe.execute(new SimplePriority(Thread.MAX_PRIORITY,"max"));
		exe.shutdown();
	}
}
