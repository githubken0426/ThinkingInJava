package th.part_16_Array._06_test_util._01;

import java.util.Arrays;

/**
 * �������
 * @author Administrator
 * 2015-11-20 ����01:25:46
 *
 */
public class FillArray {
	/**
	 * Arrays.fillֻ�����̶���ֵ��
	 * @param args
	 */
	public static void main(String[] args) {
		int size =6;
		boolean[] b=new boolean[size];
		byte[] by=new byte[size];
		char c[]=new char[size];
		Arrays.fill(b, true);
		System.out.println("b:"+Arrays.toString(b));
		Arrays.fill(by, (byte)11);
		System.out.println("by:"+Arrays.toString(by));
		Arrays.fill(c, 't');
		System.out.println("c:"+Arrays.toString(c));
	}
}
