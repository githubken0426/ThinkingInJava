package th.part_13_String.chaper_05;

import java.util.Formatter;

import th.part_11_collection.chapter_10Map.Person;

public class Receipt {
	private static double total=0;
	private static Formatter f=new Formatter(System.out);
	
	/**
	 * d ������(ʮ����)		e������(��ѧ����)
	 * c Unicode�ַ�		x ����(16����)
	 * b Booleanֵ			hɢ����(16����)
	 * s String				%�ַ�
	 * f ������(ʮ����)	
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
		 * Boolean����null,����ֵȫ(����"")��ת��Ϊtrue
		 */
		f.format("%-15s %5s %10b\n", "boolean","",null);
	}
	/**
	 * �����������̶�:Object ... objects
	 * ���������Ƕ��󣬻�����������
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
		
		Receipt.testArgs("����1","����2","����3",8,new Person());
		
		System.out.println("\\");
	}
}
