package th.part_14_TypeInfo.exercise._09;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
/**
 * 练习09
 * @author Administrator
 * 2015年9月07日
 */
public class E09_DeclareFields {
	/**
	 * getFields()获得某个类的所有的公共（public）的字段，包括父类。 
	 * 
	 * getDeclaredFields()获得某个类的所有声明的字段，即包括public、private和protected以及缺省的
	 * 但是不包括父类(包含实现的接口)的声明字段
	 */
	 static Set<Class<?>> alreadyDisplayed=new HashSet<Class<?>>();
	 
	 static void printClass(Class<?> c) throws IllegalArgumentException, IllegalAccessException{
		if(c==null) return;
		System.out.println("getName():"+c.getName());
		Field [] fields =c.getDeclaredFields();
		Field [] allFields =c.getFields();
		if(fields.length!=0){
			for (Field field : fields) {
				System.out.println("field："+field);
			}
		}
		for (Field field : fields) {
			Class<?> k=field.getType();
			if(!alreadyDisplayed.contains(k)){
				printClass(k);
				alreadyDisplayed.add(k);
			}
		}
		for(Class<?> k:c.getInterfaces()){
			System.out.println("interface:"+k.getName());
			printClass(k.getSuperclass());
		}
		printClass(c.getSuperclass());
	}
	public static void main(String[] args) throws Exception {
		
		
		for(int i=0;i<args.length;i++){
			System.out.println("args["+i+"]:"+args[i]);
			printClass(Class.forName(args[i]));
			System.out.println();
		}
	}
}
