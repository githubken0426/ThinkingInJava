package th.part_10_InnerClass.chapter_10;
/**
 * 明确的继承某个内部类
 * 
 * @author ken
 * 2016-9-23 下午04:45:01
 */
public class Egg2 {
	
	protected class Yolk{
		public Yolk(){//Egg2 step 2
			System.out.println("Constructor Egg.Yolk!");
		}
		public void f(){
			System.out.println("Method Egg.Yolk.f()!");
		}
	}
	/**
	 * 类构造过程顺序：
	 * 1 调用父类的构造函数
	 * 2 初始化类字段
	 * 3 加载构造函数
	 */
	public Egg2(){// Egg2 step 3
		System.out.println("Constructor new Egg2()");
	}
	
	private Yolk yolk =new Yolk();//Egg2 step 1
	
	public void insertYolk(Yolk yolk){
		this.yolk=yolk;
	}
	public void g(){
		yolk.f();
	}
}
