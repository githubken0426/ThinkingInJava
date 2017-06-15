package designPattern.headfirst.chapter_01Strategy.theAnswer;


public abstract class Duck {
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
