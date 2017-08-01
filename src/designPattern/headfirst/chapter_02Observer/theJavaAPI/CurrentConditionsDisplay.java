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
	/**
	 * push 使用参数Object，Object封装了参数
	 * pull 拉取Observable字段的值
	 */
	@Override
	public void update(Observable o, Object arg) {
		System.out.println(arg.getClass().getCanonicalName());
		if(o instanceof WeatherData){
			this.temprature=((WeatherData)arg).getTemprature();
			this.humidity=((WeatherData)arg).getHumidity();
			this.pressure=((WeatherData)arg).getPressure();
			display();
		}
	}

}
