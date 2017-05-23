package cn.out_memory;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * ������
 * Ҳ���� Non-heap���������洢 Object Class Data����������̬������JIT �����Ĵ���ȡ�
 * ����������������˵��ĳ�����ݴ�����ʵ����̫���ˡ�ģ��Ļ������Բ��ϴ����µ� class��ֱ�����Ϊֹ
 * 
 * @author ken
 * 2016-12-9 ����11:53:07
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
