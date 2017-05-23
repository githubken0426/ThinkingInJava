package th.part_14_TypeInfo.chapter_07_DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * 14.7 ��̬����
 * ��Ҫʵ��InvocationHandler�ӿ�
 * @author ken
 * 2016-12-6 ����09:15:16
 */
public class DynamicProxyHandler implements InvocationHandler {
	private InterfaceProxy obj;
	public DynamicProxyHandler(InterfaceProxy obj) {
		this.obj = obj;
	}

	/**
	 * �˷���������ʾ����
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("proxy��" + proxy.getClass());
		System.out.println("Method:" + method.getName() + ",args:" + args);
		if (args != null) {
			for (Object object : args) {
				System.out.println("����Ĳ���ֵ:" + object);
			}
		}
		return method.invoke(obj, args);
	}
}
