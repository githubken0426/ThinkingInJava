package th.part_14_TypeInfo.exercise._09;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
/**
 * ��ϰ09
 * @author Administrator
 * 2015��9��07��
 */
public class E09_DeclareFields {
	/**
	 * getFields()���ĳ��������еĹ�����public�����ֶΣ��������ࡣ 
	 * 
	 * getDeclaredFields()���ĳ����������������ֶΣ�������public��private��protected�Լ�ȱʡ��
	 * ���ǲ���������(����ʵ�ֵĽӿ�)�������ֶ�
	 */
	 static Set<Class<?>> alreadyDisplayed=new HashSet<Class<?>>();
	 
	 static void printClass(Class<?> c) throws IllegalArgumentException, IllegalAccessException{
		if(c==null) return;
		System.out.println("getName():"+c.getName());
		Field [] fields =c.getDeclaredFields();
		Field [] allFields =c.getFields();
		if(fields.length!=0){
			for (Field field : fields) {
				System.out.println("field��"+field);
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
