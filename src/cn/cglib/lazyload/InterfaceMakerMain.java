package cn.cglib.lazyload;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import cn.cglib.Book;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InterfaceMaker;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * �ӿ�������InterfaceMaker InterfaceMaker�ᶯ̬����һ���ӿڣ��ýӿڰ���ָ���ඨ������з���
 * 
 * @author ken 2016-12-8 ����05:09:48
 */
public class InterfaceMakerMain {
	public static Object getInstance() {
		InterfaceMaker interfaceMaker = new InterfaceMaker();
		// ��ȡĳ����ķ������ɽӿڷ���
		interfaceMaker.add(Book.class);
		Class<?> targetInterface = interfaceMaker.create();
		//���Book�����з�����
		for (Method method : targetInterface.getDeclaredMethods()) {
			System.out.println("Ҫִ�еķ���:"+method.getName());
		}
		// �ӿڴ������ô���ӿڷ�������
		Object object = Enhancer.create(Object.class,new Class[] { targetInterface }, 
				new MethodInterceptor() {
					@Override
					public Object intercept(Object obj, Method method,
							Object[] args, MethodProxy methodProxy)
							throws Throwable {
						if (method.getName().equals("update")) {
							System.out.println("filter update ");
							return 1;
						}
						if (method.getName().equals("delete")) {
							System.out.println("filter delete ");
							return "����delete���ط���ֵ";
						}
						return 0;
					}
				});
		return object;
	}

	public static void main(String[] args) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		Object object = getInstance();
		Method targetMethod1 = object.getClass().getMethod("update",
				new Class[] { int.class });
		System.out.println("update����ֵ��"+targetMethod1.invoke(object, new Object[] { 33 }));
		Method targetMethod = object.getClass().getMethod("delete",
				new Class[] {});
		System.out.println(targetMethod.invoke(object, new Object[] {}));
	}
}
