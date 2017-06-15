package designPattern.headfirst.chapter_01Strategy.theAnswer;

public class MuteQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("silence");
	}

}
