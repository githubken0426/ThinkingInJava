package designPattern.headfirst.chapter_02Observer.theJavaAPI;

/**
 * Java内置API实现观察者模式
 * 
 * @author ken
 * 2017-6-13 下午02:57:13
 */
public class WeatherData extends Observable {
	String temprature;
	String humidity;
	String pressure;
	
	public WeatherData(){}

	public String getTemprature() {
		return temprature;
	}

	public String getHumidity() {
		return humidity;
	}

	public String getPressure() {
		return pressure;
	}
	
	public void setMeasurements(String temprature,String humidity,String pressure){
		this.temprature=temprature;
		this.humidity=humidity;
		this.pressure=pressure;
		
		setChanged();
		/**
		 * 此处并没有调用notifyObservers()传递数据对象
		 * 这表示我们使用的是pull(拉)
		 */
//		notifyObservers();
		/**
		 * 推送数据push(推)
		 */
		notifyObservers(this);
	}
}
