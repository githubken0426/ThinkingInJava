package th.part_12_exception.chapter_06;

public class ReThrowNew {
	public static void f()throws OneException{
		throw new OneException("throw from f()");
	}
	/**
	 * ����Ǹ��쳣ֻ��֪��main����f()һ����֪
	 * Exception����new�ڶ��ϵĶ����������������Զ�����
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			try {
				f();
			} catch (OneException e) {
				e.printStackTrace(System.out);
				throw new TwoException("throw from TwoException");
			}
		} catch (TwoException e) {
			e.printStackTrace(System.out);
		}
	}

}
