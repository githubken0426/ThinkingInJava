package th.part_14_TypeInfo.chapter_07_DynamicProxy;

import java.lang.reflect.Proxy;

public class DynamicProxyHandlerMain {
	public static void consumer(InterfaceProxy proxied) {
		proxied.doSomething();
		proxied.somethingElse(" bonobo");
	}
	/**
	 * Proxy.newProxyInstance(ClassLoader loader, Class<?>[]
	 * interfaces,InvocationHandler h) 可以创建动态代理对象，
	 * 三个参数： 
	 * 1.ClassLoader 类加载器，
	 * 2.该代理类实现的接口列表(不是类或抽象类) 
	 * 3.InvocationHandler接口的一个实现
	 * 
	 * @param args
	 * 2015年9月14日
	 */
	public static void main(String[] args) {
		InterfaceProxy realObject = new RealObject();
		// consumer(realObject);//此处调用还是普通的代理
		Class<?>[] classes = realObject.getClass().getInterfaces();
		InterfaceProxy objectProxy = (InterfaceProxy) Proxy.newProxyInstance(
				InterfaceProxy.class.getClassLoader(),
//				new Class[] { InterfaceProxy.class },
				classes,//推荐使用反射获取接口列表
				new DynamicProxyHandler(realObject));
		consumer(objectProxy);
	}
}
