package th.part_14_TypeInfo.chapter_07_DynamicProxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {
	// 真实的代理对象
	private Object obj;

	/**
	 * 构造方法为代理对象赋值
	 * 
	 * @param obj
	 */
	public DynamicProxy(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("**befor rent house,method:" + method);
		/**
		 * 当代理对象调用真实对象的方法时， 会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
		 */
		method.invoke(obj, args);
		System.out.println("**after rent house");
		return null;
	}
}
