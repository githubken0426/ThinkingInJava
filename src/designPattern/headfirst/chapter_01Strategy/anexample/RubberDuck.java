package designPattern.headfirst.chapter_01Strategy.anexample;

/**
 * 橡皮鸭不会飞
 * 
 * @author ken
 * 2017-6-9 下午01:41:23
 */
public class RubberDuck extends Duck {

	@Override
	public void display() {
		System.out.println("橡皮鸭");
	}
	
	//解决方案：覆盖方法，什么都不做？
	@Override
	public void fly() {
		System.out.println("RubberDuck can not fly!");
	}
	
}
