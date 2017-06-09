package designPattern.headfirst.chapter_01Strategy.change01;

/**
 * ��Ȼʵ���˹��ܣ����Ǵ����ظ�����
 * �޷����á�(�����һ���Ѽ���أ�)
 * 
 * @author ken
 * 2017-6-9 ����01:49:57
 */
public class RedDuck extends Duck implements Flyable,Quackable {

	@Override
	public void display() {
		System.out.println("��ɫѼ��");
	}

	@Override
	public void fly() {
		System.out.println("��ɫ fly");
	}

	@Override
	public void quack() {
		System.out.println("��ɫ quack");
	}
	
}
