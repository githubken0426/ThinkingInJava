package th.about;

import java.lang.reflect.Field;

public class StrClass {
	
	/**
	 * string���󲻿ɱ䣬���÷���ı�String����
	 */
	public static void main(String[] args) {
		String s="Hello World";
		System.out.println("�ı�ǰ:"+s);
		try {
			Field value=String.class.getDeclaredField("value");
			value.setAccessible(true);
			char[] values=(char[]) value.get(s);
			values[5]='_';
			System.out.println("�ı��:"+s);
		} catch (NoSuchFieldException  e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
}
