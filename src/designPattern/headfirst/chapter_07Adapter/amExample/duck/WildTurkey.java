package designPattern.headfirst.chapter_07Adapter.amExample.duck;

public class WildTurkey implements Turkey {
	
	@Override
	public void quack() {
		System.out.println("WildTurkey quack!");
	}

	@Override
	public void fly() {
		System.out.println("WildTurkey flying!");
	}

}
