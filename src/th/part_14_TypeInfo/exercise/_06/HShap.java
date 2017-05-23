package th.part_14_TypeInfo.exercise._06;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class HShap {
	static boolean hightLighted=false;
	
	public static void hightLight(){
		hightLighted=true;
	}
	
	public static void clearnHightLight(){
		hightLighted=false;
	}
	
	public String toString(){
		return getClass().getName()+(hightLighted ? "hightLighted" : "normal");
	}
	
	static List<HShap> shaps=new ArrayList<HShap>();
	
	HShap(){
		shaps.add(this);
	}
	
	public void draw(){
		System.out.println(this+" draw()");
	}
	
	static void hightLight1(Class<?> t){
		for (HShap hShap : shaps) {
			if(t.isInstance(hShap)){
				HShap.hightLight();
			}
		}
	}
	
	static void clearnHightLight1(Class<?> t){
		for (HShap hShap : shaps) {
			if(t.isInstance(hShap)){
				HShap.clearnHightLight();
			}
		}
	}
	
	/**
	 * m.invoke(method, (Object[])null);
	 * object is not an instance of declaring class 反射异常
	 * 解决方法:
	 * 第一种：反射执行的方法 method 改成静态的
	 * 第二种：在执行方法前先实例化类。如m.invoke(c.newInstance(),null)
	 */
	static void forEach(Class<?> t,String method){
		try {
			Method m=HShap.class.getMethod(method, (Class<?>[])null);
			for (HShap hShap : shaps) {
				if(t.isInstance(hShap)){
					m.invoke(method, (Object[])null);
				}
			}
		}catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} 
	}
	static void hightLight2(Class<?> t){
		forEach(t,"hightLight");
	}
	static void clearnHightLight2(Class<?> t){
		forEach(t,"clearnHightLight");
	}
}
