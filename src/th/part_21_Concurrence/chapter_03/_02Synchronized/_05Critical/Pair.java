package th.part_21_Concurrence.chapter_03._02Synchronized._05Critical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 临界区（Critical section）：指的是一个访问共用资源（例如：共用设备或是共用存储器）的程序片段，
 * 而这些共用资源又无法同时被多个线程访问的特性。它使用synchronized建立
 * 当有线程进入临界区段时，其他线程或是进程必须等待（例如：bounded waiting 等待法），
 * 有一些同步的机制必须在临界区段的进入点与离开点实现，
 * 以确保这些共用资源是被互斥获得使用
 * 
 * 同步是一种更为复杂的互斥，而互斥是一种特殊的同步
 * 
 * 进程进入临界区的调度原则是：
 * 1、如果有若干进程要求进入空闲的临界区，一次仅允许一个进程进入。
 * 2、任何时候，处于临界区内的进程不可多于一个。如已有进程进入自己的临界区，
 * 	  则其它所有试图进入临界区的进程必须等待。
 * 3、进入临界区的进程要在有限时间内退出，以便其它进程能及时进入自己的临界区。
 * 4、如果进程不能进入自己的临界区，则应让出CPU，避免进程出现“忙等”现象。
 * @author Administrator
 *
 */
public class Pair {//线程不是安全的
	private int x,y;
	public Pair(){
		this(0,0);
	}
	public Pair(int x,int y){
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x++;
	}
	public int getY() {
		return y++;
	}
	
	public void incrementX(){++x;}
	
	public void incrementY(){++y;}
	
	public String toString(){
		return "X:"+x+",Y:"+y;
	}
	
	public class PariValuesNotEuqalException extends RuntimeException{
		public PariValuesNotEuqalException(){
			super("Pair not equals:"+Pair.this);
		}
	}
	//任意不变量--所有变量必须相等
	public void checkState(){
		if(x!=y)
			throw new PariValuesNotEuqalException();
	}
	
	/**
	 * 模板设计模式
	 * @author Administrator
	 * 2016-5-3 下午02:47:48
	 *
	 */
	//Pair在此类中将是线程安全的
	 abstract class PairManager{
		
		AtomicInteger atomic=new AtomicInteger();
		protected Pair pair=new Pair();
		private List<Pair> storage=Collections.synchronizedList(new ArrayList<Pair>());
		
		//复制一个原始的、线程安全的Pair
		public synchronized Pair getPair(){
			return new Pair(pair.getX(),pair.getY());
		}
		//假设一个耗时的操作
		protected void store(Pair p){
			storage.add(p);
			try {
				TimeUnit.MICROSECONDS.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		/**
		 * 模板方法
		 */
		public abstract void increment();
	}
	//1：同步整个方法
	 class PairManager1 extends PairManager{
		@Override
		public synchronized void increment() {
			super.pair.incrementX();
			super.pair.incrementY();
			super.store(getPair());
		}
	}
	/**
	 * 2：临界区-->synchronized块
	 * 当线程运行到该代码块内，就会拥有Object对象的对象锁，
	 * 如果多个线程共享同一个Object对象，那么此时就会形成互斥！
	 * 特别的，当obj == this时，表示当前调用该方法的实例对象
	 * 
	 * 使用synchronized块，PairManager2会比PairManager1锁定的时间更短
	 * 效率会高，这也是宁愿使用synchronized块的原因：使其他线程获取更多的访问机会
	 * @author Administrator
	 *
	 */
	 class PairManager2 extends PairManager{
		@Override
		public void increment() {
			Pair temp;
			synchronized(this){
				super.pair.incrementX();
				super.pair.incrementY();
				temp=getPair();
			}
			super.store(temp);//store方法已经是线程安全的，所以不用加锁
		}
	}
	
	static class PairManipulator implements Runnable{
		private PairManager pm;
		public PairManipulator(PairManager pm){
			this.pm=pm;
		}
		
		@Override
		public void run() {
			while(true)
				pm.increment();
		}
		
		public String toString(){
			return "Pair:"+pm.getPair()+",CheckerCount:"+pm.atomic.get();
		}
	}
	
	static class PairChecker implements Runnable{
		private PairManager pm;
		public PairChecker(PairManager pm){
			this.pm=pm;
		}
		
		@Override
		public void run() {
			while(true){
				pm.atomic.incrementAndGet();
				pm.getPair().checkState();
			}
		}
	}
	
	//使用Lock对象创建临界区
	 class ExplicitPairManager1 extends PairManager{
		private Lock lock=new ReentrantLock();
		
		@Override
		public synchronized void increment() {
			lock.lock();//已经lock，为何还要synchronized
			try {
				pair.incrementX();
				pair.incrementY();
				store(getPair());
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
		}
	}
	
	 class ExplicitPairManager2 extends PairManager{
		private Lock lock=new ReentrantLock();
		@Override
		public void increment() {
			Pair temp = null ;
			lock.lock();
			try {
				pair.incrementX();
				pair.incrementY();
				temp=getPair();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
			store(temp);
		}
	}
}
