package th.part_21_Concurrence.chapter_03._02Synchronized._05Critical;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import th.part_21_Concurrence.chapter_03._02Synchronized._05Critical.Pair.PairChecker;
import th.part_21_Concurrence.chapter_03._02Synchronized._05Critical.Pair.PairManager;
import th.part_21_Concurrence.chapter_03._02Synchronized._05Critical.Pair.PairManipulator;

public class CriticalSection {
	/**
	 * 测试两个不同的任务
	 * @param pman1
	 * @param pman2
	 */
	static void testApproaches(PairManager pman1,PairManager pman2){
		ExecutorService exe=Executors.newCachedThreadPool();
		PairManipulator pm1=new PairManipulator(pman1),
						pm2=new PairManipulator(pman2);
		PairChecker pchcker1=new PairChecker(pman1),
				 	pchcker2=new PairChecker(pman2);
		exe.execute(pm1);
		exe.execute(pm2);
		exe.execute(pchcker1);
		exe.execute(pchcker2);
		try {
			TimeUnit.MICROSECONDS.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Interrupted");
		}
		System.out.println("Pm1:"+pm1+"\nPm2:"+pm2);
		System.exit(0);
	}
	
	public static void main(String[] args) {
		Pair p=new Pair();
		PairManager pm1=p.new PairManager1(),
					pm2=p.new PairManager2();
		testApproaches(pm1,pm2);
	}
}
