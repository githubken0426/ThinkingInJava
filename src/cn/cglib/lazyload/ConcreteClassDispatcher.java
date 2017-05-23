package cn.cglib.lazyload;

import cn.cglib.Book;
import net.sf.cglib.proxy.Dispatcher;

/**
 * Dispatcher��ÿ�η����ӳټ�������ʱ���ᴥ��������ص�����
 * 
 * @author ken 2016-12-8 ����03:26:49
 */
public class ConcreteClassDispatcher implements Dispatcher {

	@Override
	public Object loadObject() throws Exception {
		System.out.println("before Dispatcher...");

		PropertyBean propertyBean = new PropertyBean();
		propertyBean.setKey("book");
		propertyBean.setValue(new Book());

		System.out.println("after Dispatcher...");
		return propertyBean;
	}

}
