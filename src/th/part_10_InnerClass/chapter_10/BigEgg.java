package th.part_10_InnerClass.chapter_10;

public class BigEgg extends Egg {
	/**
	 * ��ʹ�̳�����Χ�࣬
	 * Egg.Yolk��BigEgg.Yolk��������������ʵ��
	 * 
	 * @author ken
	 * 2016-9-23 ����04:13:59
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
