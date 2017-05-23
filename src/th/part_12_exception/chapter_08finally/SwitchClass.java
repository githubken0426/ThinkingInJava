package th.part_12_exception.chapter_08finally;

public class SwitchClass {
	private boolean state=false;
	
	public boolean read(){
		return state;
	}
	
	public void on(){
		state =true;
		System.out.println(this);
	}
	
	public void off(){
		state =false;
		System.out.println(this);
	}
	
	public String toString(){
		return state ? "on":"off";
	}
}
