package th.part_10_InnerClass.chapter_06;

import th.part_10_InnerClass.chapter_04.Destination;

/**
 * ʹ��ʵ����ʼ��
 * ִ�������ڲ���Ĺ��캯��
 * 
 * @author ken
 * 2016-9-21 ����10:44:47
 */
public class Parcel10 {
	public Destination destination(final String dest,final float price){
		return new Destination(){
			private int cost;
			/**
			 * ʵ����ʼ�������������ڲ���Ĺ�����
			 */
			{
				cost=Math.round(price);
				if(cost>100)
					System.out.println("Over budget!");
			}
			private String label=dest;
			@Override
			public String readLabel() {
				return label;
			}
		};
	}
	
	public static void main(String[] args) {
		Parcel10 p=new Parcel10();
		System.out.println(p.destination("Tasmania��˹���������ǰĴ���������Ψһ�ĵ���", 200).readLabel());
	}
}
