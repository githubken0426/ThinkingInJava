package th.about;

import java.lang.reflect.Field;

public class StrClass {
	
	/**
	 * string对象不可变，利用反射改变String对象
	 */
	public static void main(String[] args) {
		String s="Hello World";
		System.out.println("改变前:"+s);
		try {
			Field value=String.class.getDeclaredField("value");
			value.setAccessible(true);
			char[] values=(char[]) value.get(s);
			values[5]='_';
			System.out.println("改变后:"+s);
		} catch (NoSuchFieldException  e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
}
