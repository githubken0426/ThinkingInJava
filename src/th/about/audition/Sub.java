package th.about.audition;


public class Sub extends Base {
 	private String baseName="sub";
	
// 	public Sub(){
// 		System.out.println(baseName);
// 	}
 	
	public void callName(){
		System.out.println("Sub���:"+baseName);
	}
	/**
	 * �������ĳ�ʼ��˳������ ���ྲ̬��-->���ྲ̬��-->�����ʼ�����-->���๹�캯�� 
	 * -->�����ʼ�����-->���๹���������๹����ִ�е�ʱ��
	 * ��������������ط�����Ȼ����������ֶλ��ڸճ�ʼ���Ľ׶Σ�������ڴ沼�֣�ֻ�����null
	 * @param args
	 *	2015��10��12��
	 */
	public static void main(String[] args) {
		Base b = new Sub();
	} 
}
