package th.part_10_InnerClass.chapter_08._01Closure;


public class Caller {
	private Incrementable incrementable;
	
	public Caller(Incrementable incrementable){
		this.incrementable=incrementable;
	}
	
	public void go(){
		incrementable.increment();
	}
}
