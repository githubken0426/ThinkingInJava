package designPattern.headfirst.chapter_01Strategy.me;

public class RedDuck extends AbstractDuck {
	String color;
	public RedDuck(String color){
		super(color);
		this.color=color;
	}
	@Override
	public void display() {
		System.out.println(color);
	}

	@Override
	public void swim() {
		System.out.println(color+"����Ӿ");
	}

	public static void main(String[] args) {
		new RedDuck("��ɫѼ��").fly();
	}
	
}
