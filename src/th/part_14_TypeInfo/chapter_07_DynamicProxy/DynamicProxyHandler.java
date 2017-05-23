package th.part_14_TypeInfo.chapter_07_DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * 14.7 动态代理
 * 需要实现InvocationHandler接口
 * @author ken
 * 2016-12-6 上午09:15:16
 */
public class DynamicProxyHandler implements InvocationHandler {
	private InterfaceProxy obj;
	public DynamicProxyHandler(InterfaceProxy obj) {
		this.obj = obj;
	}

	/**
	 * 此方法不用显示调用
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("proxy：" + proxy.getClass());
		System.out.println("Method:" + method.getName() + ",args:" + args);
		if (args != null) {
			for (Object object : args) {
				System.out.println("传入的参数值:" + object);
			}
		}
		return method.invoke(obj, args);
	}
}
