package cn.out_memory;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**

 * 方法区
 * 也就是 Non-heap，是用来存储 Object Class Data、常量、静态变量、JIT 编译后的代码等。
 * 如果该区域溢出，则说明某种数据创建的实在是太多了。模拟的话，可以不断创建新的 class，直到溢出为止
 * @author ken
 * 2016-12-9 上午11:53:07
 */
public class Test_MethodArea_3 {
	 static class MethodAreaOomObject {
	    }
	    public static void main(String[] args) {
	        while(true){
//	        	System.out.println("begin");
	            Enhancer enhancer = new Enhancer();
	            enhancer.setSuperclass(MethodAreaOomObject.class);
	            enhancer.setUseCache(false);
	            enhancer.setCallback(new MethodInterceptor() {
	            	@Override
	                public Object intercept(Object obj, Method method, Object[] args,
	                        MethodProxy proxy) throws Throwable {
	                    return proxy.invoke(obj, args);
	                }
	            });
	            enhancer.create();
	        }
	    }
}
