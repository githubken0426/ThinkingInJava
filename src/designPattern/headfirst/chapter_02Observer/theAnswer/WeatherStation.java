package designPattern.headfirst.chapter_02Observer.theAnswer;

public class WeatherStation {
	public static void main(String[] args) {
		Subject data=new WeatherData();//创建主题
		//建立布告板
		DisplayElement currentDisplay=new CurrentConditionsDisplay(data);
		DisplayElement statisticDisplay=new StatisticsDisplay(data);
		data.setMeasurements("20°", "20", "50hPa");
		
	}
}
