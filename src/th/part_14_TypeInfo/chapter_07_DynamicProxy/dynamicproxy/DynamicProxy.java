package th.part_14_TypeInfo.chapter_07_DynamicProxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler{
	//��ʵ�Ĵ������
	private Object obj;
	
	/**
	 * ���췽��Ϊ�������ֵ
	 * @param obj
	 */
	public DynamicProxy(Object obj){
		this.obj=obj;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("**befor rent house");
		System.out.println("method:"+method);
		/**
		 * ��������������ʵ����ķ���ʱ��
		 * ���Զ�����ת��������������handler�����invoke���������е���
		 */
		method.invoke(obj, args);
		System.out.println("**after rent house");
		return null;
	}

}
