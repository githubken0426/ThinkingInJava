package designPattern.headfirst.chapter_07Adapter.amExample.duck;

public class MallardDuck implements Duck {

	@Override
	public void quack() {
		System.out.println("MallardDuck quack!");
	}

	@Override
	public void fly() {
		System.out.println("MallardDuck flying!");
	}
	
}
