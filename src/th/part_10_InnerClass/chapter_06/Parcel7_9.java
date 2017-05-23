package th.part_10_InnerClass.chapter_06;

import th.part_10_InnerClass.chapter_04.Destination;

/**
 * 10.6 �����ڲ���
 * �����ֶΣ���ʼ������(ʡ��Parcel9)
 * @author ken
 * 2016-9-20 ����02:22:16
 */
public class Parcel7_9 {
	public static Destination destination(final String s){
		return new Destination(){
			@Override
			public String readLabel() {
				return s;
			}
		};
	}
	
	public static void main(String[] args) {
		System.out.println(Parcel7_9.destination("test").readLabel());
	}
}
