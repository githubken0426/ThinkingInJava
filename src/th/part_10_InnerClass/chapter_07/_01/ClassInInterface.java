package th.part_10_InnerClass.chapter_07._01;

/**
 * �ӿ��ڲ���
 * Ƕ���������Ϊ�ӿڵ�һ���֣���Ϊ�ӿ��е���Ĭ����public static��
 * 
 * @author ken
 * 2016-9-22 ����03:43:08
 */
public interface ClassInInterface {
	void howdy();
	class Test implements ClassInInterface{

		@Override
		public void howdy() {
			System.out.println("howdy()");
		}
		public static void main(String[] args) {
			new Test().howdy();
		}
	}
}
