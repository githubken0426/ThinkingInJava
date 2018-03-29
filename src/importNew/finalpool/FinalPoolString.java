package importNew.finalpool;

/**
 * 常量池在String中的运用
 * String一旦创建就不能被更改，所以就是常量
 * @author ken
 * 2017-4-7 上午08:32:16
 */
public class FinalPoolString {
	public static void main(String[] args) {
		tempOne();
		tempSecond();
		tempThired();
		System.out.println("********************");
		tempFourth();
	}
	/**
	 * 编译期已经确定的值
	 * +号链接时，b经过编译器的优化，字符串的值已经确定
	 * 2017-4-7 上午08:35:43
	 */
	public static void tempOne(){
		String a="a1";
		String b="a"+1;
		System.out.println(a==b);
		
		String aa="atrue";
		String bb="a"+true;
		System.out.println(aa==bb);
	}
	/**
	 * 编译期不能确定的值
	 * 
	 * +号链接时，由于有字符串引用的存在，引用的值编译期无法确定的
	 * 只有在程序运行时，动态分配地址给cc，所以比较的是不同的字符串引用,结果为false
	 * 
	 * 2017-4-7 上午08:37:18
	 */
	public static void tempSecond(){
		String aa="atrue";
		String bb="true";
		String cc="a"+bb;
		System.out.println(aa==cc);
	}
	
	/**
	 * final常量在编译时被解析为常量值的一个本地copy，
	 * 存储到自己的常量池中或嵌入字节码流中
	 * "a"+"true"和"a"+bb效果是一样的
	 * 
	 * 2017-4-7 上午08:42:22
	 */
	public static void tempThired(){
		String aa="atrue";
		final String bb="true";
		String cc="a"+bb;
		System.out.println(aa==cc);
	}
	
	public static void tempFourth(){
		String aa="atrue";
		final String bb=getBB();
		String cc="a"+bb;
		System.out.println(aa==cc);
	}
	private static String getBB(){
		return "true";
	}
}