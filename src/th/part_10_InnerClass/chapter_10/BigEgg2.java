package th.part_10_InnerClass.chapter_10;


public class BigEgg2 extends Egg2{
	
	public class Yolk extends Egg2.Yolk{
		public Yolk(){
			System.out.println("Constructor BigEgg2.Yolk!");
		}
		public void f(){
			System.out.println("Method BigEgg2.Yolk.f()!");
		}
	}
	public BigEgg2(){
		insertYolk(new Yolk());
	}
	
	/**
	 * 1 Egg2 e 初始化Egg2
	 * 2 初始化Egg2的yolk字段(Egg2 step 1)，调用Yolk构造(Egg2 step 2)
	 * 3 调用Egg2构造(Egg2 step 3)
	 * 4 new BigEgg2()调用BigEgg2构造，然后调用insertYolk(new Yolk())，
	 * 	 然后调用BigEgg2.Yolk构造,BigEgg2.Yolk要构造先调用其父类Egg2.Yolk构造
	 * @param args
	 * 2016-9-23 下午05:21:14
	 */
	public static void main(String[] args) {
		Egg2 e=new BigEgg2();
		System.out.println("*****************************");
		e.g();
	}
}
