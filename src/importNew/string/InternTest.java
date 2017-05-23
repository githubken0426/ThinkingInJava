package importNew.string;

/**
 * jdk1.6 false
 * jdk1.7 true
 * @author ken
 * 2017-4-28 下午04:48:10
 */
public class InternTest {
	public static void main(String[] args) {
		String str2 = new String("str") + new String("01");
		str2.intern();
		/**
		 * 如果定义在str2之前，结果为false
		 * 详情importNew.string.InternTest01
		 * JDK 1.7后，intern方法还是会先去查询常量池中是否有已经存在，
		 * 如果存在，则返回常量池中的引用，这一点与之前没有区别，
		 * 区别在于，如果在常量池找不到对应的字符串，则不会再将字符串拷贝到常量池，
		 * 而只是在常量池中生成一个对原字符串的引用.
		 */
		String str1 = "str01";
		System.out.println(str2 == str1);// #7
	}
}
