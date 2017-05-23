package importNew.unkownAboutJava_10;

import java.util.Date;


public class AboutSuperClass extends Date {
	private static final long serialVersionUID = 1L;

	/**
	 * 无意识的递归：
	 * 
	 * java.lang.StackOverflowError +号使得this发生了自动类型转换，转换成String
	 * 然后再次调用toString()方法,发生递归调用，内存溢出 this应换成super.toString()
	 */

	@Override
	public String toString() {
		return "T:" + super.toString();
	}
	
	/**
	 * test 方法中调用 getClass().getName()方法，其实就是在调用从父类继承的 getClass()方法， 
	 * 等效于调用super.getClass().getName()方法，
	 * 所以super.getClass().getName()方法返回的也应该是AboutSuperClass
	 * 
	 * @author ken 2017-3-6 上午08:23:10
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
