package th.part_14_TypeInfo.chapter_07_DynamicProxy;

import java.lang.reflect.Proxy;

public class DynamicProxyHandlerMain {
	public static void consumer(InterfaceProxy proxied) {
		proxied.doSomething();
		proxied.somethingElse(" bonobo");
	}
	/**
	 * Proxy.newProxyInstance(ClassLoader loader, Class<?>[]
	 * interfaces,InvocationHandler h) ���Դ�����̬�������
	 * ���������� 
	 * 1.ClassLoader ���������
	 * 2.�ô�����ʵ�ֵĽӿ��б�(������������) 
	 * 3.InvocationHandler�ӿڵ�һ��ʵ��
	 * 
	 * @param args
	 * 2015��9��14��
	 */
	public static void main(String[] args) {
		InterfaceProxy realObject = new RealObject();
		// consumer(realObject);//�˴����û�����ͨ�Ĵ���
		Class<?>[] classes = realObject.getClass().getInterfaces();
		InterfaceProxy objectProxy = (InterfaceProxy) Proxy.newProxyInstance(
				InterfaceProxy.class.getClassLoader(),
//				new Class[] { InterfaceProxy.class },
				classes,//�Ƽ�ʹ�÷����ȡ�ӿ��б�
				new DynamicProxyHandler(realObject));
		consumer(objectProxy);
	}
}
