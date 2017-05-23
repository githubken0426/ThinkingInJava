package th.part_14_TypeInfo.chapter_07_DynamicProxy.filterMethod;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MethodsSelectorMain {
	public static void main(String[] args) {
		SomeMethods methods=new ImplementMethod();
		
		InvocationHandler handler=new MethodSelector(methods);
		
		SomeMethods some=(SomeMethods) Proxy.newProxyInstance
				(handler.getClass().getClassLoader(), methods.getClass().getInterfaces(), handler);
		some.boring1();
		some.boring2();
		some.insteresting("我要被过滤掉！");
		some.test();
	}
}
