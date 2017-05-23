package th.part_07_encapsulation.chapter_04;

public class InnerClassParcel9 {
	/**
	 * 匿名内部类运行原理
	 * 为什么参数要用final
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
	 * 仅仅是为了不报错，没有别的用处
	 * @author Administrator
	 * 注:static方法访问ABSClass，ABSClass必须也是静态的
	 */
	static class ABSClass{
		private String str;
		private ABSClass(String str){
			this.str=str;
		}
	}
	/**
	 * 编译器实际编译成这样运行
	 * 
	 * @param str
	 */
	public static void method(final String str) {
		
		class OuterClass$1 extends ABSClass {

			private final String s;
			public OuterClass$1(String s) {
				super(s);//必须显式调用构造函数，为了不报错，演示用
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
	 * 假如参数不是final
	 *  就会编译成:
	 * @param s
	 */

	public static void test3(String s) {

		class OuterClass$1 extends ABSClass {
			private String s;
			public OuterClass$1(String s) {
				super(s);//必须显式调用构造函数，为了不报错，演示用
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
