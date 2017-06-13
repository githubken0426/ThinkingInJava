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
		System.out.println("CurentConditionsDisplay,ÎÂ¶È£º" + temprature + ",Êª¶È£º"
				+ humidity + "£¬ÆøÑ¹£º" + pressure);
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
