package th.part_21_Concurrence.chapter_03._02Synchronized._06CriticalOther;

import java.util.concurrent.atomic.AtomicInteger;

import th.part_21_Concurrence.chapter_03._01WrongVisit.EvenChecker;
import th.part_21_Concurrence.chapter_03._01WrongVisit.IntGenerator;

/**
 * synchronized java封装类
 * @author Administrator
 * 2016-5-3 下午04:18:40
 *
 */
public class SynchronizedEncapsulation {
	
	/**
	 * 可以看出对封装类的同步，锁无效
	 * 这块应该是装箱、拆箱的原因
	 * 还是建议AtomicInteger、等原子类
	 * @author Administrator
	 * 2016-5-3 下午04:32:57
	 *
	 */
	static class IntegerSynchronized extends IntGenerator{
		private Double i=new Double(0);
		@Override
		public int next() {
			synchronized(i){
				i++;
				i++;
			}
			return i.intValue();
		}
	}
	
	public static void main(String[] args) {
		
		EvenChecker.test(new IntegerSynchronized(),10);
		
	}
}
