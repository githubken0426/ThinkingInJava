package th.about;

/**
 * finallyʲô����²���ִ��
 * @author Administrator
 *
 */
public class TryAndFinally {
	
	public static Object test1(){
		int a=1;
		if(a==1){
			System.out.println(0);
			return 0;//try����return��finallyҲ����ִ��
		}
		a=a/0;//try��ȥ�ͻ�ִ��finally�����򲻻�ִ��
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
	 * return finally�е�ֵ
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
	 * returnValue()�൱��String str=returnValue();return str;
	 * ���Ի����������ݣ�finally���ٷ���ֵ
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
//		System.out.println("test2()��"+test2());
//		System.out.println("return test3()��"+test3());
		System.out.println(test4());
	}
}	
