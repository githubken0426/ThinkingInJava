package designPattern.headfirst.chapter_02Observer.theJavaAPI;

/**
 * jdk 1.6 源码
 * 观察者
 * @author ken
 * 2017-6-13 pm 03:10:21
 */
public interface Observer {
	void update(Observable o, Object arg);
}
