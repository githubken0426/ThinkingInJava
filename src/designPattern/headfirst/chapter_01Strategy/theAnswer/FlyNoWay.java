package designPattern.headfirst.chapter_01Strategy.theAnswer;

public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I can not fly!");
	}

}
