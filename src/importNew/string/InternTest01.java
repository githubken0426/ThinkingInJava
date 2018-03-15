package importNew.string;

/**
 * jdk1.6 1.7 均为false
 * 
 * @author ken
 * 2017-4-28 下午04:48:22
 */
public class InternTest01 {
	public static void main(String[] args) {
		/**
		 * 为在进行字面量赋值（String str1 = "str01"）的时候，常量池中不存在，
		 * 所以str1指向的常量池中的位置，而str2指向的是堆中的对象，
		 * 再进行intern方法时，对str1和str2已经没有影响了，所以返回false
		 */
		String str1 = "str01";
		String str2 = new String("str") + new String("01");
		str2.intern();
		System.out.println(str2 == str1);// #8
	}
}