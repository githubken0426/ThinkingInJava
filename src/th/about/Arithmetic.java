package th.about;


public class Arithmetic {
	public static void main(String[] args) {
		/**
		 *  (1) 0^0=0,0^1=1  0����κ������κ���
			(2) 1^0=1,1^1=0  1����κ���=1+�κ���
			(3) �κ�������Լ������Լ���0
		 */
		System.out.println("0����κ������κ���:");
		System.out.println("0^0: "+(0^0));
		System.out.println("0^1: "+(0^1));
		System.out.println("0^-12:"+(0^-12));
		
		System.out.println("1����κ���=1+�κ���:");
		System.out.println("1^-12:"+(1^12));
		System.out.println("1^12:"+(1^12));
		System.out.println("1^-10000:"+(1^-10000));
		
		System.out.println("�κ�������Լ������Լ���0");
		System.out.println("1^1:"+(1^1));
		System.out.println("12^12:"+(6^6));
		
		System.out.println("12^-12:"+(12^-12));
		
		System.out.println(Integer.valueOf(""));
	
		
	}
}
