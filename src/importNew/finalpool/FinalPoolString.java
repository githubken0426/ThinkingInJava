package importNew.finalpool;

/**
 * ��������String�е�����
 * Stringһ�������Ͳ��ܱ����ģ����Ծ��ǳ���
 * @author ken
 * 2017-4-7 ����08:32:16
 */
public class FinalPoolString {
	public static void main(String[] args) {
		tempOne();
		tempSecond();
		tempThired();
		System.out.println("********************");
		tempFourth();
	}
	/**
	 * �������Ѿ�ȷ����ֵ
	 * +������ʱ��b�������������Ż����ַ�����ֵ�Ѿ�ȷ��
	 * 2017-4-7 ����08:35:43
	 */
	public static void tempOne(){
		String a="a1";
		String b="a"+1;
		System.out.println(a==b);
		
		String aa="atrue";
		String bb="a"+true;
		System.out.println(aa==bb);
	}
	/**
	 * �����ڲ���ȷ����ֵ
	 * 
	 * +������ʱ���������ַ������õĴ��ڣ����õ�ֵ�������޷�ȷ����
	 * ֻ���ڳ�������ʱ����̬�����ַ��cc�����ԱȽϵ��ǲ�ͬ���ַ�������,���Ϊfalse
	 * 
	 * 2017-4-7 ����08:37:18
	 */
	public static void tempSecond(){
		String aa="atrue";
		String bb="true";
		String cc="a"+bb;
		System.out.println(aa==cc);
	}
	
	/**
	 * final�����ڱ���ʱ������Ϊ����ֵ��һ������copy��
	 * �洢���Լ��ĳ������л�Ƕ���ֽ�������
	 * "a"+"true"��"a"+bbЧ����һ����
	 * 
	 * 2017-4-7 ����08:42:22
	 */
	public static void tempThired(){
		String aa="atrue";
		final String bb="true";
		String cc="a"+bb;
		System.out.println(aa==cc);
	}
	
	public static void tempFourth(){
		String aa="atrue";
		final String bb=getBB();
		String cc="a"+bb;
		System.out.println(aa==cc);
	}
	private static String getBB(){
		return "true";
	}
}
