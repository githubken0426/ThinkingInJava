package th.part_15_Generic.exercise;

public class E10_GenericMthod {
	/**
	 * 非参数化类型Boolean
	 * @param t
	 * @param b
	 * @param b1
	 *	2015年9月24日
	 */
	public static <T,B,Boolean> void get(T t,B b,Boolean b1){
		System.out.println(t.getClass().getName());
		System.out.println(b.getClass().getName());
		System.out.println(b1.getClass().getName());
	}
	
	public static void main(String[] args) {
		get(1,"上",false);
	}
}
