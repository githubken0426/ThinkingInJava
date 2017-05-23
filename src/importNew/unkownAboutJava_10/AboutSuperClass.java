package importNew.unkownAboutJava_10;

import java.util.Date;


public class AboutSuperClass extends Date {
	private static final long serialVersionUID = 1L;

	/**
	 * ����ʶ�ĵݹ飺
	 * 
	 * java.lang.StackOverflowError +��ʹ��this�������Զ�����ת����ת����String
	 * Ȼ���ٴε���toString()����,�����ݹ���ã��ڴ���� thisӦ����super.toString()
	 */

	@Override
	public String toString() {
		return "T:" + super.toString();
	}
	
	/**
	 * test �����е��� getClass().getName()��������ʵ�����ڵ��ôӸ���̳е� getClass()������ 
	 * ��Ч�ڵ���super.getClass().getName()������
	 * ����super.getClass().getName()�������ص�ҲӦ����AboutSuperClass
	 * 
	 * @author ken 2017-3-6 ����08:23:10
	 */
	public void test() {
		System.out.println(super.toString());
		// public final native java.lang.Class getClass();
		System.out.println(super.getClass());
		System.out.println(getClass().getName());
		System.out.println(this.getClass().getName());
	}

	public static void main(String[] args) {
		new AboutSuperClass().test();
		System.out.println(new AboutSuperClass());
	}

}
