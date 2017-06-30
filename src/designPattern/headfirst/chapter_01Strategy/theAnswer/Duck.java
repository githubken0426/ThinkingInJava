package designPattern.headfirst.chapter_01Strategy.theAnswer;


public abstract class Duck {
	/**
	 * 策略模式：
	 *  定义了算法组，分别封装起来，算法之间可以相互替换(使用共同的接口，算法可以替换)。算法的变化独立于使用算法的客户；
	 * 此处使用组合和委托
	 * 行为的实现委托给具体的实现类
	 */
	FlyBehavior fly;
	QuackBehavior quack;
	
	public void swim() {
		System.out.println("会游");
	}

	public abstract void display();
	
	
	public void setFly(FlyBehavior fly) {
		this.fly = fly;
	}

	public void setQuack(QuackBehavior quack) {
		this.quack = quack;
	}

	void performQuack(){
		quack.quack();
	}
	void performFly(){
		fly.fly();
	}
}
