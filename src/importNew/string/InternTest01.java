package importNew.string;

/**
 * jdk1.6 1.7 ��Ϊfalse
 * 
 * @author ken
 * 2017-4-28 ����04:48:22
 */
public class InternTest01 {
	public static void main(String[] args) {
		/**
		 * Ϊ�ڽ�����������ֵ��String str1 = "str01"����ʱ�򣬳������в����ڣ�
		 * ����str1ָ��ĳ������е�λ�ã���str2ָ����Ƕ��еĶ���
		 * �ٽ���intern����ʱ����str1��str2�Ѿ�û��Ӱ���ˣ����Է���false
		 */
		String str1 = "str01";
		String str2 = new String("str") + new String("01");
		str2.intern();
		System.out.println(str2 == str1);// #8
	}
}
