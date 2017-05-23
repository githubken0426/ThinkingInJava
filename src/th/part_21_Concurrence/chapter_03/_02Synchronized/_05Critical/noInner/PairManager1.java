package th.part_21_Concurrence.chapter_03._02Synchronized._05Critical.noInner;

public class PairManager1 extends PairManager {

	@Override
	public synchronized void increment() {
		super.pair.incrementX();
		super.pair.incrementY();
		super.store(getPair());
	}

}
