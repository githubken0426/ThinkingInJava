package th.part_21_Concurrence.chapter_03._02Synchronized._04AtomicClass;

import java.util.concurrent.atomic.AtomicInteger;

import th.part_21_Concurrence.chapter_03._01WrongVisit.EvenChecker;
import th.part_21_Concurrence.chapter_03._01WrongVisit.IntGenerator;

/**
 * 通常依赖锁会更安全一些
 * @author Administrator
 *
 */
public class AtomicEvenGenerator extends IntGenerator {
	private AtomicInteger currentValue=new AtomicInteger(0);
	
	@Override
	public int next() {
		return currentValue.addAndGet(2);
	}

	public static void main(String[] args) {
		EvenChecker.test(new AtomicEvenGenerator());
	}
}
