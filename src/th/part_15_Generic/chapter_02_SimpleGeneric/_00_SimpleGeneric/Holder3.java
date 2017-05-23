package th.part_15_Generic.chapter_02_SimpleGeneric._00_SimpleGeneric;

public class Holder3<T> {
	private T t;
	
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
	
	
	public  Holder3(T t){
		this.t=t;
	}
	
	public T get(){
		return t;
	}
	
	public void set(T t){
		this.t=t;
	}
	
	public static void main(String[] args) {
		Holder3<AutoMobile> h3=new Holder3<AutoMobile>(new AutoMobile());
		AutoMobile au=h3.get();
	}
}
