package th.part_14_TypeInfo.chapter_07_DynamicProxy.filterMethod;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MethodSelector implements InvocationHandler {
	private Object obj;
	
	public MethodSelector(Object obj){
		this.obj=obj;
	}	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if(method.getName().equals("insteresting")){
			System.out.println("¹ýÂËinteresting·½·¨£¡");
			return null;
		}
		return method.invoke(obj, args);
	}

}
