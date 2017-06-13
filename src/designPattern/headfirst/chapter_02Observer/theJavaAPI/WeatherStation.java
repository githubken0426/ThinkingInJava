package designPattern.headfirst.chapter_02Observer.theJavaAPI;

public class WeatherStation {
	public static void main(String[] args) {
		WeatherData observable=new WeatherData();//主题
		//观察者
		DisplayElement currentDisplay=new CurrentConditionsDisplay(observable);
		DisplayElement statisticDisplay=new StatisticsDisplay(observable);
		
		observable.setMeasurements("20°", "20", "50hPa","test");
	}
}
