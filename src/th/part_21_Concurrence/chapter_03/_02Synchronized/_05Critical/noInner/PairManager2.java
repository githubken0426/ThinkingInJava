package th.part_21_Concurrence.chapter_03._02Synchronized._05Critical.noInner;


public class PairManager2 extends PairManager {

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
