package th.part_15_Generic.chapter_10_WildCard._00;


/**
 * ͨ���
 * WildCard
 * 
 * @author ken
 * 2016-10-26 ����11:28:25
 */
public class CovariantArrays {
	public static void main(String[] args) {
		Fruit f=new Fruit();
		Fruit[] fruit=new Fruit.Apple[10];
		fruit[0]=f.new Apple();
		
	}
}
