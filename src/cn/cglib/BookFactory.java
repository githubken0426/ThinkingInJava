package cn.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Enhancer����CGLib�е�һ���ֽ�����ǿ����
 * �����Է���Ķ�����Ҫ������������չ
 * 
 * @author ken
 * 2016-12-7 ����09:42:40
 */
public class BookFactory {
	private static Enhancer en=null;
	public static Book getInstance(MyCglibProxy proxy){
		if(en==null)
			en=new Enhancer();
		en.setSuperclass(Book.class);
		en.setCallback(proxy);
		Book book=(Book) en.create();
		System.out.println(book);
		return book;
	}
}
