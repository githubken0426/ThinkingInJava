package designPattern.headfirst.chapter_01Strategy.change01;


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
}
