package cn.cglib.lazyload;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import cn.cglib.Book;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InterfaceMaker;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 接口生成器InterfaceMaker InterfaceMaker会动态生成一个接口，该接口包含指定类定义的所有方法
 * 
 * @author ken 2016-12-8 下午05:09:48
 */
public class InterfaceMakerMain {
	public static Object getInstance() {
		InterfaceMaker interfaceMaker = new InterfaceMaker();
		// 抽取某个类的方法生成接口方法
		interfaceMaker.add(Book.class);
		Class<?> targetInterface = interfaceMaker.create();
		//输出Book的所有方法名
		for (Method method : targetInterface.getDeclaredMethods()) {
			System.out.println("要执行的方法:"+method.getName());
		}
		// 接口代理并设置代理接口方法拦截
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
							return "我是delete返回返回值";
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
		System.out.println("update返回值:"+targetMethod1.invoke(object, new Object[] { 33 }));
		Method targetMethod = object.getClass().getMethod("delete",
				new Class[] {});
		System.out.println(targetMethod.invoke(object, new Object[] {}));
	}
}
