package th.part_21_Concurrence.chapter_02._06Priority;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimplePriority implements Runnable{
	private int countDown=5;
	/**
	 * volatile�� ָ��ؼ��֣�ȷ������ָ�������������Ż���ʡ�ԣ���Ҫ��ÿ��ֱ�Ӷ�ֵ
	 */
	private volatile double d;//no optimization(���������Ż�)
	private int priority;
	
	public SimplePriority(int priority){
		this.priority=priority;
	}
	
	public String toString(){
		return Thread.currentThread()+":"+countDown;
	}
	
	@Override
	public void run() {
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
			exe.execute(new SimplePriority(Thread.MIN_PRIORITY));
		/**
		 * ע�⣺���ȼ�����run()��ͷ���趨�ģ��ڹ���������û���κκô�
		 * ��ΪExecutor��û�п�ʼִ������
		 */
		exe.execute(new SimplePriority(Thread.MAX_PRIORITY));
		exe.shutdown();
	}
}
