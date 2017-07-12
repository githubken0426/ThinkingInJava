package designPattern.headfirst.chapter_06Command.advanced.receiver;

public class Light {
	String position;
	public Light(String position){
		this.position=position;
	}
	public void on(){
		System.out.println(position+" on!");
	}
	
	public void off(){
		System.out.println(position+" off!");
	}
}
