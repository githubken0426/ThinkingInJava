package designPattern.headfirst.chapter_01Strategy.me;

/**
 * 我的解决方案
 *  定义抽象类，将统一的方法抽象出来，供继承者调用
 *  继承者可以调用自定义的fly和quack方法，来实现飞行和叫
 * 
 * @author ken 2017-6-9 下午02:05:58
 */
public abstract class AbstractDuck {
	String color;

	public AbstractDuck(String color) {
		this.color = color;
	}

	public abstract void swim();

	public abstract void display();

	public void fly() {
		System.out.println(color + " can fly");
	}

	public void quack() {
		System.out.println(color + " can quack");
	}
}
