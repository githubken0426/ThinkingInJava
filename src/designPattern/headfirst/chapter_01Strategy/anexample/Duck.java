package designPattern.headfirst.chapter_01Strategy.anexample;


public class Duck {
	public void quack() {
		System.out.println("呱呱");
	}

	public void swim() {
		System.out.println("会游");
	}

	public void display() {
		System.out.println("羽毛颜色");
	}
	
	/**
	 * 新功能：会飞的鸭子
	 * 2017-6-9 下午01:37:42
	 */
	public void fly(){
		System.out.println("Im flying");
	}
}
