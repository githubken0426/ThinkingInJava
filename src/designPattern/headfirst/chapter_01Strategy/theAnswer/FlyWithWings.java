package designPattern.headfirst.chapter_01Strategy.theAnswer;


public class FlyWithWings implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I am flying!");
	}

}
