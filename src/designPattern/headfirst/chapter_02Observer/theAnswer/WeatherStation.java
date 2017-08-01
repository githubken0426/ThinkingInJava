package designPattern.headfirst.chapter_02Observer.theAnswer;

public class WeatherStation {
	public static void main(String[] args) {
		Subject data=new WeatherData();//����(���۲���)
		//�۲���
		DisplayElement currentDisplay=new CurrentConditionsDisplay(data);
		DisplayElement statisticDisplay=new StatisticsDisplay(data);
		data.setMeasurements("20°", "20", "50hPa");
		
	}
}
