package designPattern.headfirst.chapter_02Observer.theAnswer;

public class StatisticsDisplay implements DisplayElement, Observer {

	String temprature;
	String humidity;
	String pressure;
	private Subject subject;
	
	StatisticsDisplay(Subject subject){
		this.subject=subject;
		this.subject.registerObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("StatisticsDisplay统计avg/max/min," + temprature + "/"
				+ temprature + "/" + temprature);
	}

	@Override
	public void update(String temprature, String humidity, String pressure) {
		this.temprature=temprature;
		this.humidity=humidity;
		this.pressure=pressure;
		display();
	}

}
