package th.part_07_encapsulation.chapter_06;

import th.part_07_encapsulation.chapter_06.Parcel3.PDestination;

public class Parcel5 extends PDestination {
	/**
	 * �ⲿ��̳��ڲ��࣬���˼̳�Ҫ��ʽ���ø����вι�����
	 * ��Ҫ��������ڲ���������,���²�����parcel3
	 * ��ΪPDestination��Parcel3����ڲ��࣬
	 * ���Ա�����Parcel3����������PDestination��Ĺ��캯��
	 * @param parcel3
	 * @param label
	 */
	public Parcel5(Parcel3 parcel3, String label) {
		parcel3.super(label);
	}

}
