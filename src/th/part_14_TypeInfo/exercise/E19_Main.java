package th.part_14_TypeInfo.exercise;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import th.part_14_TypeInfo.chapter_02._01.GetClass.Toy;

/**
 * 通过非默认构造器创造Toy对象
 * @param toyName
 * @param iq
 * @return
 *	2015年9月11日
 */
public class E19_Main {
	
	private static Toy makeToy(String toyName,int iq){
		try {
			Class<?> c=Class.forName(toyName);
			for(Constructor<?> constructor:c.getConstructors()){
				Class<?>[] parms=constructor.getParameterTypes();
				if(parms.length==1){
					if(parms[0]==int.class){
						try {
							return (Toy) constructor.newInstance(new Object[]{
									Integer.valueOf(iq)
							});
						} catch (InstantiationException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		String className="th.part_14_TypeInfo.chapter_06.exercise.SuperToy";
		System.out.println(makeToy(className,150));
	}
}
