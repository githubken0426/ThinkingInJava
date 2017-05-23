package th.part_10_InnerClass.chapter_05;

import th.part_10_InnerClass.chapter_04.Destination;

/**
 * 10.5 在方法和作用域的内部
 * 
 * @author ken
 * 2016-9-20 下午02:22:16
 */
public class Parcel5 {
	public static Destination destination(final String s){
		class DestinationImpl implements Destination{
			private String str;
			DestinationImpl(String str){
				this.str=str;
			}
			@Override
			public String readLabel() {
				return str;
			}
		}
		return new DestinationImpl(s);
	}
	
	public static void main(String[] args) {
		System.out.println(Parcel5.destination("test").readLabel());
	}
}
