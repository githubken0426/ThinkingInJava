package cn.cglib;

/**
 * ʵ���� û��ʵ���κνӿ�
 * @author ken 2016-12-7 ����09:37:52
 */
public class Book {
	public String create() {
		System.out.println("����create();");
		return "����create";
	}
	public String query() {
		System.out.println("����query();");
		return "����query";
	}
	//�˷���Ϊ��������������ֵ��FixedValue�ӿڲ��ԡ�
	public Integer update(int count) {
		System.out.println("����update();");
		return count;
	}
	public String delete() {
		System.out.println("����delete();");
		return "����delete";
	}
	public String toString() {
		return "Book " + getClass();
	}
}
