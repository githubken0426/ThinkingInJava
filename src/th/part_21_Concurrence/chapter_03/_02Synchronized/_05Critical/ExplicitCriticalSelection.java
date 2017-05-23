package th.part_21_Concurrence.chapter_03._02Synchronized._05Critical;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import th.part_21_Concurrence.chapter_03._02Synchronized._05Critical.Pair.PairChecker;
import th.part_21_Concurrence.chapter_03._02Synchronized._05Critical.Pair.PairManager;
import th.part_21_Concurrence.chapter_03._02Synchronized._05Critical.Pair.PairManipulator;

public class ExplicitCriticalSelection {
	
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
	/**
	 * 非静态内部类对main(静态方法)而言是不直接可见的，也就无法直接访问
	 * 非静态内部类需要实例化一个对象调用：如下
	 * @param args
	 */
	public static void main(String[] args) {
		Pair p=new Pair();
		PairManager pm1=p.new ExplicitPairManager1(),
				pm2=p.new ExplicitPairManager2();
		testApproaches(pm1,pm2);
	}
}	
