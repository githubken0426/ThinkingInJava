package importNew.string;

/**
 * jdk1.6 false
 * jdk1.7 true
 * @author ken
 * 2017-4-28 ����04:48:10
 */
public class InternTest {
	public static void main(String[] args) {
		String str2 = new String("str") + new String("01");
		str2.intern();
		/**
		 * ���������str2֮ǰ�����Ϊfalse
		 * ����importNew.string.InternTest01
		 * JDK 1.7��intern�������ǻ���ȥ��ѯ���������Ƿ����Ѿ����ڣ�
		 * ������ڣ��򷵻س������е����ã���һ����֮ǰû������
		 * �������ڣ�����ڳ������Ҳ�����Ӧ���ַ������򲻻��ٽ��ַ��������������أ�
		 * ��ֻ���ڳ�����������һ����ԭ�ַ���������.
		 */
		String str1 = "str01";
		System.out.println(str2 == str1);// #7
	}
}
