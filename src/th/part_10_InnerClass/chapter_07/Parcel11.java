package th.part_10_InnerClass.chapter_07;

import th.part_10_InnerClass.chapter_04.Contents;
import th.part_10_InnerClass.chapter_04.Destination;

/**
 * 10.7 嵌套类
 * 如果不需要内部类对象和外围类对象有联系，可以将内部类声明为static,这通常叫嵌套类
 * 普通内部类对象隐式保存率一个引用，指向创建它的外围类对象。
 * 嵌套类意味着:
 * 	1)创建嵌套类的对象，不需要外围类对象
 *  2)不能从嵌套类的对象中访问非静态的外围类对象
 * 
 * @author ken
 * 2016-9-22 下午02:57:28
 */
public class Parcel11 {
	private static int a=0;
	private static class PercalContents implements Contents{
		private int i=11;
		@Override
		public int value() {
			return i+a;
		}
	}
	
	protected static class PercalDestination implements Destination{
		private String label;
		private PercalDestination(String label){
			this.label=label;
		}
		
		@Override
		public String readLabel() {
			return label;
		}
		
		public static void f(){}
		static int x=10;
		static class AnotherLevel{
			public static void f(){
				System.out.println("AnotherLevel f()");
			}
			static int x=10;
		}
	}
	
	public static Destination destination(String des){
		return new PercalDestination(des);
	}
	
	public static Contents contents(){
		return new PercalContents();
	}
	
	public static void main(String[] args) {
		Contents c=contents();
		System.out.println(c.value());
		Destination des=destination("Tasmania");
		System.out.println(des.readLabel());
		PercalDestination.AnotherLevel.f();
		
	}
}
