package th.part_10_InnerClass.chapter_10;

/**
 * 10.10
 * 内部类可以被覆盖吗？
 * 
 * @author ken
 * 2016-9-23 下午02:04:40
 */
public class Egg {
	private Yolk y;
	public Egg(){
		System.out.println("new Egg()");
		y=new Yolk();
	}
	
	protected class Yolk{
		public Yolk(){
			System.out.println("Egg.Yolk!");
		}
	}
}
