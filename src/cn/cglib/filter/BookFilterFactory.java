package cn.cglib.filter;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import cn.cglib.Book;
import cn.cglib.MyCglibProxy;

public class BookFilterFactory {
	private static Enhancer en = null;

	/**
	 * @param proxy ����������
	 * @return 2016-12-7 ����11:08:33
	 */
	public static Book getInstanceByFilter(MyCglibProxy proxy) {
//		//ԭ���룺������ֵ�
//		 if(en==null)
//			 en=new Enhancer();
		Enhancer en = new Enhancer();//�޸ĺ�
		en.setSuperclass(Book.class);
		// Callback noopCb=NoOp.INSTANCE;
		// Callback callback=proxy;
		// Callback fixedValue=new TargetResultFixed();
		// Callback[] callbacks=new Callback[]{callback,noopCb,fixedValue};
		// en.setCallbacks(callbacks);
		
		/**
		 * setCallbacks�ж�������ʹ�õ���������
		 * ����NoOp.INSTANCE��CGlib���ṩ��ʵ����һ��û���κβ�������������
		 * �����������,һ��Ҫ��CallbackFilter(��MyProxyFilter)�����˳��һ�¡�
		 * MyProxyFilter��return����(0/1/2)�ľ��Ƿ��ص�˳��
		 */
		en.setCallbacks(new Callback[] { proxy, NoOp.INSTANCE,new TargetResultFixed() });
		en.setCallbackFilter(new MyProxyFilter());
		return (Book) en.create();
	}
}
