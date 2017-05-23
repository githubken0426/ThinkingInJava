package th.part_10_InnerClass.chapter_10;

public class BigEgg extends Egg {
	/**
	 * 即使继承了外围类，
	 * Egg.Yolk和BigEgg.Yolk还是两个独立的实体
	 * 
	 * @author ken
	 * 2016-9-23 下午04:13:59
	 */
	public class Yolk{
		public Yolk(){
			System.out.println("BigEgg.Yolk");
		}
	}
	public static void main(String[] args) {
		new BigEgg();
	}
}
