package th.about.audition;


public class Sub extends Base {
 	private String baseName="sub";
	
// 	public Sub(){
// 		System.out.println(baseName);
// 	}
 	
	public void callName(){
		System.out.println("Sub输出:"+baseName);
	}
	/**
	 * 构造器的初始化顺序大概是 父类静态块-->子类静态块-->父类初始化语句-->父类构造函器 
	 * -->子类初始化语句-->子类构造器。父类构造器执行的时候，
	 * 调用了子类的重载方法，然而子类的类字段还在刚初始化的阶段，刚完成内存布局，只能输出null
	 * @param args
	 *	2015年10月12日
	 */
	public static void main(String[] args) {
		Base b = new Sub();
	} 
}
