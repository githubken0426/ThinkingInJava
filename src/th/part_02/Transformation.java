package th.part_02;

/**
 * ����ת��
 * @author Administrator
 * 2015��9��10��
 */

public class Transformation {
	public static void main(String[] args) {
		decimal_Binary();
		decimal_Octonary();
		decimal_Hexadecimal();
		
	}
	
	/**
	 * 10����ת��������
	 * ��Ҫת����������2���õ������ٳ���2��ֱ����Ϊ0��Ȼ������Ƕ����ƽ��
	 * @param args
	 *	2015��9��10��
	 */
	private static void decimal_Binary(){
		/**
		 * ������ ������� �� ����
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
		System.out.println(a+"ת���ɶ����ƣ�"+str);
	}
	
	/**
	 * 10����ת��8����
	 * ��Ҫת����������8���õ������ٳ���8��ֱ����Ϊ0��Ȼ�������8���ƽ��
	 * @param args
	 *	2015��9��10��
	 */
	private static void decimal_Octonary(){
		/**
		 * ������ ������� �� ����
		 * 100		100/8  12  4
		 *  12       12/8   1  4
		 *  1        1/8    0  1
		 */
		int a=100;
		int result=0144;
		System.out.println(a+"ת���ɰ˽��ƣ�"+result);
	}
	
	/**
	 * 10����ת��16����
	 * ��Ҫת����������16���õ������ٳ���16��ֱ����Ϊ0��Ȼ�������16���ƽ��
	 * @param args
	 *	2015��9��10��
	 */
	private static void decimal_Hexadecimal(){
		/**
		 * ������ ������� �� ����
		 * 100	   100/16   6  4
		 *  6       6/16    0  6
		 *  
		 */
		int a=100;
		int result=0x64;
		System.out.println(a+"ת����ʮ�����ƣ�"+result);
	}
	
	

}
