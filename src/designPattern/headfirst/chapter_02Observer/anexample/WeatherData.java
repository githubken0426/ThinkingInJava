package designPattern.headfirst.chapter_02Observer.anexample;

public class WeatherData {
	/**
	 * 温度
	 * 
	 * 2017-6-13 上午09:04:55
	 */
	public String getTemperature(){
		System.out.println("温度：17/23°");
		return "17/23°";
	}
	/**
	 * 湿度
	 * 
	 * 2017-6-13 上午09:05:19
	 */
	public String getHumidity(){
		System.out.println("湿度：32");
		return "32";
	}
	/**
	 * 气压
	 * 
	 * 2017-6-13 上午09:05:43
	 */
	public String getPressure(){
		System.out.println("气压：500hPa");
		return "500hPa";
	}
	
	/**
	 * 数据有变动就要调用此方法更新
	 * 
	 * 2017-6-13 上午10:00:56
	 */
	public void measurementsChanged(){
		String temprature=getTemperature();
		String humidity=getHumidity();
		String pressure=getPressure();
		
		//更新模板
		/*currentDisplay.update(temprature,humidity,pressure);
		statisticDisplay.update(temprature,humidity,pressure);
		forecastDisplay.update(temprature,humidity,pressure);*/
	}
}
