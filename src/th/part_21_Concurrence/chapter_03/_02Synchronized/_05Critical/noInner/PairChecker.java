package th.part_21_Concurrence.chapter_03._02Synchronized._05Critical.noInner;


public class PairChecker implements Runnable {

	private PairManager pm;
	public PairChecker(PairManager pm){
		this.pm=pm;
	}
	
	@Override
	public void run() {
		while(true){
			pm.atomic.incrementAndGet();
		}
	}

}
