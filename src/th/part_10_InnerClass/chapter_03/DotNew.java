package th.part_10_InnerClass.chapter_03;

/**
 * �ⲿ�����.new Inner() ������ĳ���ڲ������
 * @author Administrator
 *
 * 2016-9-20 ����08:44:48
 */
public class DotNew {
	public class Inner{}
	public static void main(String[] args) {
		Inner in=new DotNew().new Inner();
		System.out.println(in);
	}
}
