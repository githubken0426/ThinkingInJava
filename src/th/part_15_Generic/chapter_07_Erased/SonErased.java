package th.part_15_Generic.chapter_07_Erased;

/**
 * 关于擦除2
 * 
 * @author ken
 * 2017-5-17 上午11:12:24
 */
public class SonErased extends AboutErased<String>{
	private String t1;
	private String t2;
	public SonErased(String t1, String t2) {
		super(t1, t2);
		this.t1=t1;
		this.t2=t2;
	} 
	
	/**
	 * AboutErased<String>在编译阶段已经被类型擦除为AboutErased了，
	 * 它的setT1方法变成了setT1(Object fir)。 
	 * 那么SonErased中setT1(String)当然无法覆盖住父类的setT1(Object)了。
	 * 这对于多态来说确实是个不小的麻烦，我们看看编译器是如何解决这个问题的。
	 * 编译器 会自动在 SonErased中生成一个桥方法(bridge method ) ： 
           public void setT1(Object fir){
               setT1((String) fir)
           }
     * 
	 */
	public void setT1(String str){
		System.out.println("子类 setT1");
		this.t1=str;
	}
	/**
	 * 需要桥方法来覆盖父类中的getFirst，编译器会自动在SonPair中生成一个 
	 * public Object getFirst()桥方法。
	 * 但是，疑问来了，SonPair中出现了两个方法签名一样的方法(只是返回类型不同)：
            ①String getFirst()  // 自己定义的方法
            ②Object getFirst()  // 编译器生成的桥方法 
            
	 * 难道，编译器允许出现方法签名相同的多个方法存在于一个类中吗？
	 * JVM会用参数类型和返回类型来确定一个方法。 
	 * 一旦编译器通过某种方式自己编译出方法签名一样的两个方法
	 * (只能编译器自己来创造这种奇迹，我们程序员却不能人为的编写这种代码)。
	 * JVM还是能够分清楚这些方法的，前提是需要返回类型不一样
	 */
	public String getT1(){
		System.out.println("子类 getT1");
		return t1;
	}
	public static void main(String[] args) {
		SonErased son=new SonErased("a","b");
		System.out.println(son.getT1());
		
		SonErased[] stringPairs=new SonErased[10];
		//泛型数组：compile error:
//		SonErased<Integer>[] intPairs=new SonErased<Integer>[10];

	}
}
