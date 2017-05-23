package th.part_21_Concurrence.chapter_03._02Synchronized._05Critical.noInner;


public class PairManipulator implements Runnable {

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
