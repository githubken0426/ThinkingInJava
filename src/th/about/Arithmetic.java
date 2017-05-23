package th.about;


public class Arithmetic {
	public static void main(String[] args) {
		/**
		 *  (1) 0^0=0,0^1=1  0异或任何数＝任何数
			(2) 1^0=1,1^1=0  1异或任何数=1+任何数
			(3) 任何数异或自己＝把自己置0
		 */
		System.out.println("0异或任何数＝任何数:");
		System.out.println("0^0: "+(0^0));
		System.out.println("0^1: "+(0^1));
		System.out.println("0^-12:"+(0^-12));
		
		System.out.println("1异或任何数=1+任何数:");
		System.out.println("1^-12:"+(1^12));
		System.out.println("1^12:"+(1^12));
		System.out.println("1^-10000:"+(1^-10000));
		
		System.out.println("任何数异或自己＝把自己置0");
		System.out.println("1^1:"+(1^1));
		System.out.println("12^12:"+(6^6));
		
		System.out.println("12^-12:"+(12^-12));
		
		System.out.println(Integer.valueOf(""));
	
		
	}
}
