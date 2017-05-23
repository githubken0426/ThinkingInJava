package th.part_12_exception.chapter_06._01stackTrace;

public class WhoCalled {
	/**
	 * getStackTrace()��������һ����ջ�켣�е�Ԫ����ɵ�����
	 * ÿ��Ԫ�ر�ʾջ�е�һ֡
	 * Ԫ��0(ջ��)�ǵ��������е����һ������
	 * ջ�������һ����������
	 * 
	 * 2017-4-14 ����08:22:39
	 */
	static void f(){
		try {
			throw new Exception();
		} catch (Exception e) {
			for (StackTraceElement ele : e.getStackTrace()) {
				System.out.println(ele.getMethodName());
			}
		}
	}
	static void g(){
		f();
	}
	public static void main(String[] args) {
		f();
		System.out.println("****************");
		g();
	}
}
