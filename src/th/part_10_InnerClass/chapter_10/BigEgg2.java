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
	 * 1 Egg2 e ��ʼ��Egg2
	 * 2 ��ʼ��Egg2��yolk�ֶ�(Egg2 step 1)������Yolk����(Egg2 step 2)
	 * 3 ����Egg2����(Egg2 step 3)
	 * 4 new BigEgg2()����BigEgg2���죬Ȼ�����insertYolk(new Yolk())��
	 * 	 Ȼ�����BigEgg2.Yolk����,BigEgg2.YolkҪ�����ȵ����丸��Egg2.Yolk����
	 * @param args
	 * 2016-9-23 ����05:21:14
	 */
	public static void main(String[] args) {
		Egg2 e=new BigEgg2();
		System.out.println("*****************************");
		e.g();
	}
}
