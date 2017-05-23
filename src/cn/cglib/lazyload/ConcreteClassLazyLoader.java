package cn.cglib.lazyload;

import cn.cglib.Book;
import net.sf.cglib.proxy.LazyLoader;

/**
 * ����Ҫ�ӳټ��صĶ�����Ӵ����ڻ�ȡ�ö�������ʱ��ͨ��������ص��������ж����ʼ����
 * �ڲ���Ҫ���ظö���ʱ��ֻҪ��ȥ��ȡ�ö��������ԣ��ö���Ͳ��ᱻ��ʼ����
 * (��CGLib��ʵ����ֻҪȥ���ʸö��������Ե�getter������
 * �ͻ��Զ�����������ص�����
 * 
 * @author ken
 * 2016-12-8 ����03:24:49
 */
public class ConcreteClassLazyLoader implements LazyLoader {

	@Override
	public Object loadObject() throws Exception {
		System.out.println("before lazyLoader...");
		
		PropertyBean propertyBean = new PropertyBean();
		propertyBean.setKey("book");
		propertyBean.setValue(new Book());
		
		System.out.println("after lazyLoader...");
		return propertyBean;
	}

}
