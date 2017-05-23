package th.part_10_InnerClass.chapter_07;

import th.part_10_InnerClass.chapter_04.Contents;
import th.part_10_InnerClass.chapter_04.Destination;

/**
 * 10.7 Ƕ����
 * �������Ҫ�ڲ���������Χ���������ϵ�����Խ��ڲ�������Ϊstatic,��ͨ����Ƕ����
 * ��ͨ�ڲ��������ʽ������һ�����ã�ָ�򴴽�������Χ�����
 * Ƕ������ζ��:
 * 	1)����Ƕ����Ķ��󣬲���Ҫ��Χ�����
 *  2)���ܴ�Ƕ����Ķ����з��ʷǾ�̬����Χ�����
 * 
 * @author ken
 * 2016-9-22 ����02:57:28
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
