package th.part_14_TypeInfo.chapter_09;

import java.lang.reflect.Method;

import th.part_14_TypeInfo.chapter_09._01hidden.HiddenC;

public class HiddenImplementation {
	private static void callHiddenMethod(Object obj,String methodName)throws Exception{
		Method m=obj.getClass().getDeclaredMethod(methodName);
		//������������Ȩ��
		m.setAccessible(true);
		m.invoke(obj);
	}
	public static void main(String[] args) throws Exception {
		InteA a=HiddenC.makeA();
		a.f();
		a.g();
		System.out.println(a.getClass().getCanonicalName());
		/**
		 * �������C�ǰ�����ģ����ʲ���
		 */
//		InteA a2=new C();
//		if(a instanceof C)
		callHiddenMethod(a,"c");
		callHiddenMethod(a,"u");
		callHiddenMethod(a,"v");
	}
}
