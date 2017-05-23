package th.part_06.chapter_01;

public class Sprinkler {
	private static String str1;
	static int  i;
	WaterSource source;
	
	public static void print(){
		System.out.println("str1:"+str1);
		System.out.println("i:"+i);
		/**
		 * 先执行构造函数，在执行toString方法
		 */
		System.out.println("source:"+new WaterSource());
	}
	public static void main(String[] args) {
		print();
	}
}
