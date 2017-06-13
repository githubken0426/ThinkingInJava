package designPattern.headfirst.chapter_02Observer.theAnswer;

/**
 * �����--ʵ��
 * 
 * @author ken
 * 2017-6-13 ����11:58:04
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
	String temprature;
	String humidity;
	String pressure;
	private Subject subject;
	
	CurrentConditionsDisplay(Subject subject){
		this.subject=subject;
		this.subject.registerObserver(this);
	}
	
	@Override
	public void update(String temprature, String humidity, String pressure) {
		this.temprature=temprature;
		this.humidity=humidity;
		this.pressure=pressure;
		display();
	}

	@Override
	public void display() {
		System.out.println("CurentConditionsDisplay,�¶ȣ�" + temprature + ",ʪ�ȣ�"
				+ humidity + "����ѹ��" + pressure);
	}

}
