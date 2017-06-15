package designPattern.headfirst.chapter_01Strategy.theAnswer;

import designPattern.headfirst.chapter_01Strategy.change01.Flyable;

public class FlyNoWay implements Flyable {

	@Override
	public void fly() {
		System.out.println("I can not fly!");
	}

}
