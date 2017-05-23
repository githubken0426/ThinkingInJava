package th.part_15_Generic.chapter_04_GenericMethod._00;

/**
 * 泛型方法
 * @author Administrator
 * 2015年9月24日
 */

public class GenericMethods {
	private static <U> U get(U u){
		return (U) u.getClass().getName();
	}
	
	public static void main(String[] args) {
		System.out.println(get(2));
		System.out.println(get(2f));
		System.out.println(get(2l));
		System.out.println(get(2d));
		System.out.println(get("2"));
		System.out.println(get('a'));
		byte b=120;
		System.out.println(get(b));
		short s=10;
		System.out.println(get(s));
	}
}
