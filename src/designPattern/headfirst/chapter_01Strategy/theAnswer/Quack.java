package designPattern.headfirst.chapter_01Strategy.theAnswer;

public class Quack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("quack");
	}

}
