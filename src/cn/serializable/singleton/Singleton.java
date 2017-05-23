package cn.serializable.singleton;

import java.io.Serializable;

/**
 * 序列化破坏单例模式
 * @author Administrator
 * 2016-3-4 下午02:02:16
 *
 */
public class Singleton implements Serializable {
	private static final long serialVersionUID = 1L;
	private volatile static Singleton singleton=null;
	private Singleton(){}
	
	public static Singleton getInstance(){
		if(singleton==null){
			synchronized(Singleton.class){
				if(singleton==null)
					singleton=new Singleton();
			}
		}
		return singleton;
	}
}
