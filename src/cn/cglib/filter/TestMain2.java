package cn.cglib.filter;

import cn.cglib.Book;
import cn.cglib.MyCglibProxy;

public class TestMain2 {
	public static void main(String[] args) {
		Book book1 = BookFilterFactory.getInstanceByFilter(new MyCglibProxy("boss")); 
		book1.create(); 
		book1.query();
		book1.delete();
		//update的返回值锁定为888
		System.out.println(book1.update(100));
		System.out.println("------------------------------------------------");
		
		Book book2 = BookFilterFactory.getInstanceByFilter(new MyCglibProxy("kisi"));  
		book2.create(); 
		book2.delete();
		book2.query(); 
		//update的返回值锁定为888
		System.out.println(book2.update(200));
	}
}
