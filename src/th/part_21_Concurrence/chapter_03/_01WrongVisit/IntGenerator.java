package th.part_21_Concurrence.chapter_03._01WrongVisit;


public abstract class IntGenerator {
	private volatile  boolean cancel=false;
	
	public void cacel(){
		cancel=true;
	}
	
	public boolean isCancel(){
		return cancel;
	}
	
	public abstract int next();
}
