package cn.out_memory;

public class Test_String {
	/**
	 * ������.class�ļ��еĳ����أ��������ڱ�JVMװ�أ����ҿ������䡣
	 * String��intern()�����������䳣���ص�һ�� ������
	 * ��һ��Stringʵ��str����intern()����ʱ��
	 * Java���ҳ��������Ƿ�����ͬUnicode���ַ���������
	 * ����У��򷵻�������ã� ���û�У����ڳ�����������һ��Unicode����str���ַ�����������������
	 * @param args
	 * 2016-12-9 ����01:49:35
	 */
	public static void main(String[] args) {
		String kill="kill";
		String kill2=new String("kill");
		String kill3="ki"+"ll";
		System.out.println(kill==kill3);
		System.out.println(kill==kill2.intern());
		//��Ȼִ����kill2.intern(),�����ķ���ֵû�и���kill2
		System.out.println(kill==kill2);
	}
}
