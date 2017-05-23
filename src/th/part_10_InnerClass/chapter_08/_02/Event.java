package th.part_10_InnerClass.chapter_08._02;
/**
 * 10.8.2 
 * 内部类与控制框架
 * 
 * @author ken
 * 2016-9-23 上午09:37:59
 */
public abstract class Event {
	
	@SuppressWarnings("unused")
	private long eventTime;
	protected final long delayTime;
	
	public Event(long delayTime){
		  this.delayTime=delayTime;
		  start();
	}
	
	public void start(){
		eventTime=System.nanoTime()+delayTime;
	}
	
	public boolean ready(){
		return System.nanoTime()>delayTime;
	}
	public abstract void action();
}
