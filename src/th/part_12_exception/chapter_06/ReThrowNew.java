package th.part_12_exception.chapter_06;

public class ReThrowNew {
	public static void f()throws OneException{
		throw new OneException("throw from f()");
	}
	/**
	 * 最后那个异常只是知道main，对f()一无所知
	 * Exception都是new在堆上的对象。垃圾回收器会自动清理
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
