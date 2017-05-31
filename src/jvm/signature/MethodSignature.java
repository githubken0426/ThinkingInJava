package jvm.signature;

/**
 * 方法签名
 * 
 * @author ken 2017-5-31 上午08:53:40
 */
public class MethodSignature {
	public void test1() {
	} // test1()V

	public void test2(String str) {
	}// test2(Ljava/lang/String;)V

	public int test3() {
		return 1;
	} // test3()I

	public void test() {

	}

	public void test(String str) {

	}

	public Object test(Object str) {
		return str;
	}
	
	public static void main(String[] args) {
		MethodSignature sign=new MethodSignature();
		Object obj=sign.test((Object)"abc");
		System.out.println(obj);
	}
}
