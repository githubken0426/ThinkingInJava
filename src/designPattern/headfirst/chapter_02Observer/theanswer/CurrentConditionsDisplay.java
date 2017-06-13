package designPattern.headfirst.chapter_02Observer.theanswer;

/**
 * 布告板--实现
 * 
 * @author ken
 * 2017-6-13 上午11:58:04
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
	String temprature;
	String humidity;
	String pressure;
	private Subject subject;
	
	CurrentConditionsDisplay(Subject subject){
		this.subject=subject;
		subject.registerObserver(this);
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
		System.out.println("CurentConditionsDisplay,温度：" + temprature + ",湿度："
				+ humidity + "，气压：" + pressure);
	}

}
