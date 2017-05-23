package cn.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Enhancer类是CGLib中的一个字节码增强器，
 * 它可以方便的对你想要处理的类进行扩展
 * 
 * @author ken
 * 2016-12-7 上午09:42:40
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
