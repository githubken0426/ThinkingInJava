package th.part_14_TypeInfo.chapter_09;

import java.lang.reflect.Method;

import th.part_14_TypeInfo.chapter_09._01hidden.B;

/**
 * ͨ��������ƻ�ȡ˽�з���
 * @author Administrator
 * 2015��9��16��
 */
public class CallHiddenMethod {
	
	public static void getHiddenMethod(Object obj,String methodName,String parm,int age) throws Exception{
		/**
		 * ���䴫����
		 */
		Method methods =obj.getClass().getDeclaredMethod(methodName,new Class[]{String.class,int.class});
		methods.setAccessible(true);
		methods.invoke(obj,parm,age);
	}
	
	public static void getHiddenMethod(Object obj,String methodName) throws Exception{
		
		Method methods =obj.getClass().getDeclaredMethod(methodName);
		methods.setAccessible(true);
		methods.invoke(obj);
	}
	
	public static void main(String[] args) throws Exception {
		InteA a=new B();
		B  b=B.B_Class.getB();
		getHiddenMethod(a,"c","lisi",24);
		getHiddenMethod(b,"b_c");
	}
}
