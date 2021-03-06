package th.part_02;
/**
 * 16进制
 * @author Administrator
 * 2015年9月10日
 */
public class Hexadecimal {
	public static void main(String[] args) {
		/**
		 * 16进制用0,1,2,3,4,5,6,7,8,9,A(10),B(11),C(12),D(13),E(15),F(15)
		 * 16个数字(字母不区分大小写).
		 * 逢16进1，第0位为16的0次方，第1位为16的1次方，第n位为16的n次方...
		 * 
		 * java里16进制可以为负值,必须以0x开头
		 * c/c++16进制没有负值
		 */
		int a=0x12af;
		//16进制转10进制
		int b=15+10*16+2*16*16+1*16*16*16;
		
		System.out.println("a="+a+",b="+b);
		System.out.println("a==b:"+(a==b));
		
		/**
		 * 二进制转16进制
		 * 二进制   1111       1010       1001     0101
		 *         [8,4,2,1] [8,0,4,0]  [8,0,0,1] [0,4,0,1]
		 * 16进制   F(15)      C(12)        9         5
		 * 16进制转2进制
		 * 1-0001,2-0010,3-0011，4-0100,5-0101,6-0110,7-0111,8-1000,
		 * 9-1001，A-1010，B-1011，C-1100，D-1101,E-1110，F-1111
		 */
		
		System.out.println(0x95);
		//int t = 00000000 00000000 00000000 01100100;
	}
}
