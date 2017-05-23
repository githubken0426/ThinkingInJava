package cn.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import org.apache.log4j.Logger;
/**
 * ��̬����Ȩ������
 * @author Administrator
 * 2016-1-5 ����11:54:09
 */
public class MyCglibProxy implements MethodInterceptor {
	private Logger logger=Logger.getLogger(MyCglibProxy.class);
	private String name;
	public MyCglibProxy(String name){
		this.name=name;
	}
	/**
	 * ������ObjectΪ��CGLib��̬���ɵĴ�����ʵ����
	 * MethodΪ������ʵ���������õı�����ķ������ã�
	 * Object[]Ϊ����ֵ�б�MethodProxyΪ���ɵĴ�����Է����Ĵ������á�
	 * ���أ��Ӵ���ʵ���ķ������÷��ص�ֵ��
	 * ���У�methodProxy.invokeSuper(obj,arg)��
 	 * ���ô�����ʵ���ϵ�proxy�����ĸ��෽������ʵ����Book�ж�Ӧ�ķ�����
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] arg2,
			MethodProxy methodProxy) throws Throwable {
		logger.info("MethodInterceptor����ǰ��"+ method.getName());
		if(! "boss".equals(name)){//ֻ��boss���ܵ���delete����
			System.out.println("��û��Ȩ�ޣ�");
			return null;
		}
		Object result=methodProxy.invokeSuper(obj, arg2);
		System.out.println("MethodInterceptor���ú�:"+result);
		return result;
	}
}	
//	public Object getBean(Class<?> cl){
//	enhancer.setSuperclass(cl);
//	enhancer.setCallback(this);
//	return enhancer.create();
//}

