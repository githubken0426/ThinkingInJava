package th.part_07_encapsulation.chapter_06;

import th.part_07_encapsulation.chapter_06.Parcel3.PDestination;

public class Parcel5 extends PDestination {
	/**
	 * 外部类继承内部类，除了继承要显式调用父类有参构造外
	 * 还要传入包含内部类的类参数,如下参数：parcel3
	 * 因为PDestination是Parcel3类的内部类，
	 * 所以必须用Parcel3对象来调用PDestination类的构造函数
	 * @param parcel3
	 * @param label
	 */
	public Parcel5(Parcel3 parcel3, String label) {
		parcel3.super(label);
	}

}
