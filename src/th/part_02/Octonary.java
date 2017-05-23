package th.part_02;
/**
 * 八进制
 * @author Administrator
 * 2015年9月10日
 */
public class Octonary {

	public static void main(String[] args) {
		/**
		 * 8进制用0,1,2,3,4,5,6,7表达一个数
		 * 逢8进1，java用0开头代表一个8进制数
		 * 第0位为8的0次方，第1位为8的1次方，第n位为8的n次方...
		 */
		int a=0144;
		int b=4+4*8+1*8*8;
		int c='\144';
		System.out.println("a="+a+",b="+b);
		System.out.println(c);
		
		/**
		 * 8进制转16进制
		 * 2的三次方是8，所以可以看成三位二进制数为一位八进制数
		 * 八进制    1      4      4
		 * 二进制   001    100    100
		 * 	结果:	1100100
		 * 	按照四位分开，(不足四位，最前面或小数点最后面补0)
		 * 			0110 0100
		 * 十六进制  6     4    
		 */
		System.out.println(0x64);
	}

}
