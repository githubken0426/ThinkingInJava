package th.part_14_TypeInfo.chapter_08_NullObject._01;

import th.part_14_TypeInfo.chapter_08_NullObject.NullInterface;

public class Person {
	public final String first;
	public final String last;
	public final String address;
	
	public Person(String first,String last,String address){
		this.first=first;
		this.last=last;
		this.address=address;
	}
	
	public String toString(){
		return "Person:"+first+" "+last+" "+address;
	}
	
	/**
	 * 空对象设计模式
	 * @author Administrator
	 * 2016-3-29 下午04:21:24
	 *
	 */
	public static class NullPerson extends Person implements NullInterface{

		public NullPerson() {
			super("none","none", "none");
		}
		public String toString(){
			return "Null Object Parttern--空对象设计模式！";
		}
	}
	public static final Person NULL=new NullPerson();
	
}	
