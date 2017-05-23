package th.part_14_TypeInfo.chapter_07_DynamicProxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
/**
 * ��̬�������
 * @author Administrator
 * 2015��9��14��
 */
public class DynamicProxyMain {

	public static void main(String[] args) {
		//��ʵ�������
		Subject realSubject=new RealSubject();
		//������ʵ�Ķ���
		InvocationHandler handler=new DynamicProxy(realSubject);
		
		/**
         * ͨ��Proxy��newProxyInstance�������������ǵĴ��������������������������
         * 
         * ��һ������ handler.getClass().getClassLoader() ��
         * ��������ʹ��handler������ClassLoader�������������ǵĴ������
         * 
         * �ڶ�������realSubject.getClass().getInterfaces()��
         * ��������Ϊ��������ṩ�Ľӿ�����ʵ������ʵ�еĽӿڣ���ʾ��Ҫ������Ǹ���ʵ����
         * �����Ҿ��ܵ�������ӿ��еķ�����
         * 
         * ����������handler�� �������ｫ������������������Ϸ��� InvocationHandler ���������
         */
		/**
		 * ��������Ϊ���ص��������������Subject���͵Ķ��󣬻�����InvocationHandler�Ķ���
		 * ���ȴ���ǣ��������ǽ���һ��Ϊʲô����������Խ���ת��ΪSubject���͵Ķ���
		 * ԭ�������newProxyInstance��������ĵڶ��������ϣ����Ǹ������������ṩ��һ��ʲô�ӿڣ�
		 * ��ô������������ͻ�ʵ��������ӿڣ����ʱ�����ǵ�Ȼ���Խ�����������ǿ������ת��Ϊ
		 * ����ӿ��е�����һ������Ϊ����Ľӿ���Subject���ͣ����ԾͿ��Խ���ת��ΪSubject�����ˡ�
		 */
	
		Subject subject=(Subject) Proxy.newProxyInstance
				(handler.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), handler);
		System.out.println("&&"+subject.getClass().getName());
		subject.rent();
		subject.cons("rent yet!");
	}

}
