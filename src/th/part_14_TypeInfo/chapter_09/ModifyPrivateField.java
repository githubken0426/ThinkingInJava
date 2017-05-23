package th.part_14_TypeInfo.chapter_09;

import java.lang.reflect.Field;

public class ModifyPrivateField {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		WithPrivateFinalField with=new WithPrivateFinalField();
		System.out.println(with);
		
		Field f=with.getClass().getDeclaredField("i");
		f.setAccessible(true);
		System.out.println("f.getInt(with)="+f.getInt(with));
		
		f.setInt(with, 47);
		System.out.println(with);
		
		System.out.println("***********************");
		f=with.getClass().getDeclaredField("str");
		f.setAccessible(true);
		System.out.println("f.get(with)="+f.get(with));
		f.set(with,"No,you are not!");
		System.out.println(with);
		
		System.out.println("***********************");
		f=with.getClass().getDeclaredField("s2");
		f.setAccessible(true);
		System.out.println("f.get(with)="+f.get(with));
		f.set(with,"No,you are not!");
		System.out.println(with);
		
	}
}
