package th.about;

/**
 * finally什么情况下不会执行
 * @author Administrator
 *
 */
public class TryAndFinally {
	
	public static Object test1(){
		int a=1;
		if(a==1){
			System.out.println(0);
			return 0;//try外面return，finally也不会执行
		}
		a=a/0;//try进去就会执行finally，否则不会执行
		try {
			System.out.println("Try block!");
			return a;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Catch block!");
			return 0;
		}finally{
			System.out.println("Fianlly block!");
		}
	}
	
	public static Object test2(){
		try {
			System.out.println("Try block!");
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Catch block!");
			return 0;
		}finally{
			System.out.println("Fianlly block!");
		}
	}
	
	/**
	 * return finally中的值
	 * @return
	 */
	public static Object test3(){
		try {
			return "Try";
		} catch (Exception e) {
			e.printStackTrace();
			return "Catch";
		}finally{
			return "Finally";
		}
	}
	
	/**
	 * returnValue()相当于String str=returnValue();return str;
	 * 所以会先输入内容，finally后，再返回值
	 * @return
	 */
	public static Object test4(){
		try {
			System.out.println("Try block!");
			return returnValue();
		} catch (Exception e) {
			e.printStackTrace();
			return "Catch";
		}finally{
			System.out.println("Finally block!");
		}
	}
	public static String returnValue() {  
		 System.out.println("return statement");  
		 return "after return";  
	}
	
	public static void main(String[] args) {
//		test1();
//		System.out.println("test2()："+test2());
//		System.out.println("return test3()："+test3());
		System.out.println(test4());
	}
}	
