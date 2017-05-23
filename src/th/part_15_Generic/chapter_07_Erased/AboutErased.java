package th.part_15_Generic.chapter_07_Erased;

/**
 * 关于擦除1
 * 
 * @author ken
 * @param <T>
 * 2017-5-17 上午11:13:30
 */
public class AboutErased<T> {
	private T t1;
	private T t2;
	
	public  AboutErased(T t1,T t2){
		this.t1=t1;
		this.t2=t2;
	}

	public T getT1() {
		System.out.println("父类 getT1");
		return t1;
	}
	public void setT1(T t1) {
		System.out.println("父类 setT1");
		this.t1 = t1;
	}

	public T getT2() {
		return t2;
	}
	public void setT2(T t2) {
		this.t2 = t2;
	}
	
	/**
	 * compile error:
	 * Name clash: The method equals(T) of type Holder3<T> 
	 * has the same erasure as equals(Object) of 
	 * type Object but does not override it.
	 * 
	 * 1.子类方法要覆盖，必须与父类方法具有相同的方法签名（方法名+参数列表）。
	 *   而且必须保证子类的访问权限>=父类的访问权限;
	 * 2.当编译器看到Pair<T>中的equals(T)方法时，
	 * 	 第一反应当然是equals(T)没有覆盖住父类Object中的equals(Object)了。
       3.接着、编译器将泛型代码中的T用Object替代（擦除）。
       	 突然发现擦除以后equals(T)变成了equals(Object)，糟糕了，这个方法与Object类中的equals一样了
	 * @param t
	 */
	/*public boolean equals(T a){
		return a.equals(t);
	}*/
	
	public static void main(String[] args) {
		/**
		 * T被擦除为Object,此时传入的参数都正常
		 * JVM会根据第一个参数"string"推算出T类型变量是String类型，
		 * 这样getT2()也应该是返回String类型.故抛出转换异常。
		 */
		AboutErased<String> erased1=new AboutErased("a",1);
		//java.lang.ClassCastException
		System.out.println(erased1.getT2());
		//compile error:
//		AboutErased<String> erased=new AboutErased<String>("a",1);
	}
}
