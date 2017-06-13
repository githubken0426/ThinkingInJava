package designPattern.headfirst.chapter_02Observer.theAnswer;

/**
 * 主题
 * 
 * @author ken
 * 2017-6-13 上午10:52:45
 */
public interface Subject {
	/**
	 * 注册主题
	 * 
	 * 2017-6-13 上午11:06:13
	 */
	public void registerObserver(Observer ob);
	/**
	 * 移除主题
	 * 
	 * 2017-6-13 上午11:06:23
	 */
	public void removeObserver(Observer ob);
	/**
	 * 更改主题
	 * 
	 * 2017-6-13 上午11:06:33
	 */
	public void notifyObserver();
	
	public void setMeasurements(String temprature,String humidity,String pressure);
}
