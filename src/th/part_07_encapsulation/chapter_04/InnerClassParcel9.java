package th.part_07_encapsulation.chapter_04;

public class InnerClassParcel9 {
	/**
	 * �����ڲ�������ԭ��
	 * Ϊʲô����Ҫ��final
	 * @param s
	 */
	public static void test(final String s) {
		class ABSClass {
			public void m() {
				int x = s.hashCode();
				System.out.println(x);
			}
		}
	}
	
	/**
	 * ������Ϊ�˲�����û�б���ô�
	 * @author Administrator
	 * ע:static��������ABSClass��ABSClass����Ҳ�Ǿ�̬��
	 */
	static class ABSClass{
		private String str;
		private ABSClass(String str){
			this.str=str;
		}
	}
	/**
	 * ������ʵ�ʱ������������
	 * 
	 * @param str
	 */
	public static void method(final String str) {
		
		class OuterClass$1 extends ABSClass {

			private final String s;
			public OuterClass$1(String s) {
				super(s);//������ʽ���ù��캯����Ϊ�˲�������ʾ��
				this.s = s;
			}
			public void m() {
				int x = s.hashCode();
				System.out.println(x);
			}
		}
		;
		ABSClass c = new OuterClass$1(str);
	}

	/**
	 * �����������final
	 *  �ͻ�����:
	 * @param s
	 */

	public static void test3(String s) {

		class OuterClass$1 extends ABSClass {
			private String s;
			public OuterClass$1(String s) {
				super(s);//������ʽ���ù��캯����Ϊ�˲�������ʾ��
				this.s = s;
			}
			public void m() {
				s = "other";
			}
		}
		;
		ABSClass c = new OuterClass$1(s);
	}
}
