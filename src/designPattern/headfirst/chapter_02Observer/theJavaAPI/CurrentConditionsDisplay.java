package designPattern.headfirst.chapter_02Observer.theJavaAPI;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	String temprature;
	String humidity;
	String pressure;
	private Observable observable;
	
	CurrentConditionsDisplay(Observable observable){
		this.observable=observable;
		this.observable.addObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("CurentConditionsDisplay,温度：" + temprature + ",湿度："
				+ humidity + "，气压：" + pressure);
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(arg);
		if(o instanceof WeatherData){
			this.temprature=((WeatherData)o).getTemprature();
			this.humidity=((WeatherData)o).getHumidity();
			this.pressure=((WeatherData)o).getPressure();
			display();
		}
	}

}
