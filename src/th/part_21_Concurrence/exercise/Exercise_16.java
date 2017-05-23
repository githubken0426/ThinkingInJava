package th.part_21_Concurrence.exercise;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Exercise_16 {
	private Lock lockF=new ReentrantLock();
	private Lock lockH=new ReentrantLock();
	private Lock lockG=new ReentrantLock();
	
	public void f(){
		lockF.lock();
		try {
			for(int i=1;i<=5;i++){
				System.out.println("f()方法第:"+i+"次！");
				TimeUnit.SECONDS.sleep(1);
				Thread.yield();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lockF.unlock();
		}
	}
	
	public void h(){
		lockH.lock();
		try {
			for(int i=1;i<=5;i++){
				System.out.println("h()方法第:"+i+"次！");
				TimeUnit.SECONDS.sleep(1);
				Thread.yield();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lockH.unlock();
		}
	}
	
	public void g(){
		lockG.lock();
		try {
			for(int i=1;i<=5;i++){
				System.out.println("g()方法第:"+i+"次！");
				TimeUnit.SECONDS.sleep(1);
				Thread.yield();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lockG.unlock();
		}
	}
	
	public static void main(String[] args) {
		final Exercise_16 exe=new Exercise_16();
		new Thread(){
			public void run(){
				exe.f();
			}
		}.start();
		
		new Thread(){
			public void run(){
				exe.g();
			}
		}.start();
		exe.h();
	}
}
