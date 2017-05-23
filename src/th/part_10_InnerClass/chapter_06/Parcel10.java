package th.part_10_InnerClass.chapter_06;

import th.part_10_InnerClass.chapter_04.Destination;

/**
 * 使用实例初始化
 * 执行匿名内部类的构造函数
 * 
 * @author ken
 * 2016-9-21 上午10:44:47
 */
public class Parcel10 {
	public Destination destination(final String dest,final float price){
		return new Destination(){
			private int cost;
			/**
			 * 实例初始化类似于匿名内部类的构造器
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
		System.out.println(p.destination("Tasmania塔斯马尼亚州是澳大利亚联邦唯一的岛州", 200).readLabel());
	}
}
