package th.part_10_InnerClass.chapter_07._01;

/**
 * 接口内部类
 * 嵌套类可以作为接口的一部分，因为接口中的类默认是public static的
 * 
 * @author ken
 * 2016-9-22 下午03:43:08
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
