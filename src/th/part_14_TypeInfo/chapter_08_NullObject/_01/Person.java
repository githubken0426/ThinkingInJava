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
	 * �ն������ģʽ
	 * @author Administrator
	 * 2016-3-29 ����04:21:24
	 *
	 */
	public static class NullPerson extends Person implements NullInterface{

		public NullPerson() {
			super("none","none", "none");
		}
		public String toString(){
			return "Null Object Parttern--�ն������ģʽ��";
		}
	}
	public static final Person NULL=new NullPerson();
	
}	
