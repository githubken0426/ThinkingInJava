package designPattern.headfirst.chapter_01Strategy.change01;

/**
 * 虽然实现了功能，但是大量重复代码
 * 无法复用。(如果有一万个鸭子呢？)
 * 
 * @author ken
 * 2017-6-9 下午01:49:57
 */
public class RedDuck extends Duck implements Flyable,Quackable {

	@Override
	public void display() {
		System.out.println("红色鸭子");
	}

	@Override
	public void fly() {
		System.out.println("红色 fly");
	}

	@Override
	public void quack() {
		System.out.println("红色 quack");
	}
	
}
