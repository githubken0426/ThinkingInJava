package th.part_10_InnerClass.chapter_03;

/**
 * 外部类对象.new Inner() 来创建某个内部类对象
 * @author Administrator
 *
 * 2016-9-20 上午08:44:48
 */
public class DotNew {
	public class Inner{}
	public static void main(String[] args) {
		Inner in=new DotNew().new Inner();
		System.out.println(in);
	}
}
