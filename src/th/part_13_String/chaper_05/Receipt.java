package th.part_13_String.chaper_05;

import java.util.Formatter;

import th.part_11_collection.chapter_10Map.Person;

public class Receipt {
	private static double total=0;
	private static Formatter f=new Formatter(System.out);
	
	/**
	 * d 整数型(十进制)		e浮点数(科学计数)
	 * c Unicode字符		x 整数(16进制)
	 * b Boolean值			h散列码(16进制)
	 * s String				%字符
	 * f 浮点数(十进制)	
	 */
	public static void printTitle(){
		f.format("%-15s %5s %10s\n", "Item","Quantity","Price");
		f.format("%-15s %5s %10s\n", "--","--","--");
	}
	
	public static void print(String name,int qty,double price){
		f.format("%-15s %5s %10.2f\n", name,qty,price);
		total+=price;
	}
	
	public static void total(){
		f.format("%-15s %5s %10s\n", "","","----");
		f.format("%-15s %5s %10.2f\n", "Total","",total);
		/**
		 * Boolean除了null,其他值全(包括"")部转换为true
		 */
		f.format("%-15s %5s %10b\n", "boolean","",null);
	}
	/**
	 * 参数数量不固定:Object ... objects
	 * 参数可以是对象，基本数据类型
	 * @param objects
	 */
	public static void testArgs(Object ... objects){
		for (Object object : objects) {
			System.out.println(object);
		}
	}
	
	
	public static void main(String[] args) {
		Receipt.printTitle();
		Receipt.print("jack is shirt", 4, 20.50);
		Receipt.total();
		
		System.out.println(String.format("this is :%d", 20));
		
		Receipt.testArgs("参数1","参数2","参数3",8,new Person());
		
		System.out.println("\\");
	}
}
