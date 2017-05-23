package th.part_15_Generic.chapter_05_InnerClass;

import th.util.Generator;

/**
 * 匿名内部类
 * @author Administrator
 * 2015年9月28日
 */
public class Customer {
	private static  long count=1;
	private final long id=count++;
	
	private Customer(){}
	
	public String toString(){
		return "Customer "+id;
	}
	
	public static Generator<Customer> generator(){
		return new Generator(){
			@Override
			public Customer next() {
				return new Customer();
			}
		};
	}
}
