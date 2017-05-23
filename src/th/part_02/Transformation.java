package th.part_02;

/**
 * 进制转换
 * @author Administrator
 * 2015年9月10日
 */

public class Transformation {
	public static void main(String[] args) {
		decimal_Binary();
		decimal_Octonary();
		decimal_Hexadecimal();
		
	}
	
	/**
	 * 10进制转换二进制
	 * 把要转换的数除以2，得到的商再除以2，直到商为0，然后倒序就是二进制结果
	 * @param args
	 *	2015年9月10日
	 */
	private static void decimal_Binary(){
		/**
		 * 被除数 计算过程 商 余数
		 * 100		100/2  50  0
		 *  50       50/2  25  0
		 *  25       25/2  12  1
		 *  12       12/2   6  0
		 *  6         6/2   3  0
		 *  3         3/2   1  1
		 *  1         1/2   0  1
		 */
		int a=100;
		String str="1100100";
		System.out.println(a+"转换成二进制："+str);
	}
	
	/**
	 * 10进制转换8进制
	 * 把要转换的数除以8，得到的商再除以8，直到商为0，然后倒序就是8进制结果
	 * @param args
	 *	2015年9月10日
	 */
	private static void decimal_Octonary(){
		/**
		 * 被除数 计算过程 商 余数
		 * 100		100/8  12  4
		 *  12       12/8   1  4
		 *  1        1/8    0  1
		 */
		int a=100;
		int result=0144;
		System.out.println(a+"转换成八进制："+result);
	}
	
	/**
	 * 10进制转换16进制
	 * 把要转换的数除以16，得到的商再除以16，直到商为0，然后倒序就是16进制结果
	 * @param args
	 *	2015年9月10日
	 */
	private static void decimal_Hexadecimal(){
		/**
		 * 被除数 计算过程 商 余数
		 * 100	   100/16   6  4
		 *  6       6/16    0  6
		 *  
		 */
		int a=100;
		int result=0x64;
		System.out.println(a+"转换成十六进制："+result);
	}
	
	

}
