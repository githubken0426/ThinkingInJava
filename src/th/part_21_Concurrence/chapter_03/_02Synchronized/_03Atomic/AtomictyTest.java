package th.part_21_Concurrence.chapter_03._02Synchronized._03Atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 一：原子性
 * 原子是世界上的最小单位，具有不可分割性。比如 a=0；（a非long和double类型） 这个操作是不可分割的，
 * 那么我们说这个操作时原子操作。再比如：a++； 这个操作实际是a = a + 1；是可分割的，所以他不是一个原子操作。
 * 非原子操作都会存在线程安全问题，需要我们使用同步技术（synchronized）来让它变成一个原子操作。
 * 一个操作是原子操作，那么我们称它具有原子性。java的concurrent包下提供了一些原子类，
 * 我们可以通过阅读API来了解这些原子类的用法。比如：AtomicInteger、AtomicLong、AtomicReference等。
 * 
 * 二：可见性
 * 是指线程之间的可见性，一个线程修改的状态对另一个线程是可见的。
 * 也就是一个线程修改的结果。另一个线程马上就能看到。
 * 比如：用volatile修饰的变量，就会具有可见性。
 * volatile修饰的变量不允许线程内部缓存和重排序，即直接修改内存。
 * 所以对其他线程是可见的。但是这里需要注意一个问题，volatile只能让被他修饰内容具有可见性，
 * 但不能保证它具有原子性。比如 volatile int a = 0；之后有一个操作 a++；这个变量a具有可见性，
 * 但是a++ 依然是一个非原子操作，也就这这个操作同样存在线程安全问题。
 * 
 * JVM会将64位的long、double的读取和写入分割成两个32位操作来执行
 * 这就产生了读取和写入的上下文切换，从而导致不同的任务产生不同的结果
 * volatile是java se5后的特性，之前并不支持，所以最好不要依赖平台特性
 * @author Administrator
 *
 */

public class AtomictyTest implements Runnable {
	private volatile int i=0;//变量不是volatile修饰,存在可视性问题
	
	/**
	 * 虽然evenCrement()方法是同步的，getValue()方法的return i也是原子性操作，
	 * 但是缺少同步使得i在中间状态时(JVM get或put时)候被读取
	 * @return
	 */
	public  int getValue(){//synchronized
		return i;
	}
	
	private synchronized void evenCrement(){
		++i;
		++i;
	}
	
	@Override
	public void run() {
		while(true)
			evenCrement();
	}

	public static void main(String[] args) {
		ExecutorService exe=Executors.newCachedThreadPool();
		AtomictyTest atom = new AtomictyTest();
		exe.execute(atom);
		while(true){
			int val=atom.getValue();
			if(val %2!=0){
				System.out.println("奇数："+val);
				System.exit(0);
			}
		}
	}
}
