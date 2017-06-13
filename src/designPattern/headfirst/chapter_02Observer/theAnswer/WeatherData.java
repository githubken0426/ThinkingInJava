package designPattern.headfirst.chapter_02Observer.theAnswer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject{
	private List<Observer> observers;
	String temprature;
	String humidity;
	String pressure;
	
	WeatherData(){
		observers=new ArrayList<Observer>();
	}
	
	@Override
	public void notifyObserver() {
		for (Observer ob : observers) {
			ob.update(temprature, humidity, pressure);
		}
	}
	@Override
	public void registerObserver(Observer ob) {
		if(!observers.contains(ob))
			observers.add(ob);
	}
	@Override
	public void removeObserver(Observer ob) {
		if(observers.contains(ob))
			observers.remove(ob);
	}
	/**
	 * 当从气象站观测到新的信息通知观察�?
	 * @param temprature
	 * @param humidity
	 * @param pressure
	 * 2017-6-13 下午01:52:42
	 */
	@Override
	public void setMeasurements(String temprature,String humidity,String pressure){
		this.temprature=temprature;
		this.humidity=humidity;
		this.pressure=pressure;
		
		notifyObserver();
	}
}
