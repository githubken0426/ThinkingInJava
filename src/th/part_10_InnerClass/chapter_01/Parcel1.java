package th.part_10_InnerClass.chapter_01;
/**
 * 10.1 �����ڲ���
 * @author Administrator
 *
 * 2016-9-19 ����11:45:13
 * [p��:rsl] ����������
 */
public class Parcel1 {
	class Contents{
		private int i=11;
		public int value(){
			return i;
		}
	}
	
	class Destination{
		private String label;
		Destination(String label){
			this.label=label;
		}
		String readLabel(){
			return label;
		}
	}
	public static void ship(String dest){
//		Contents c=new Parcel1().new Contents();
		Destination d=new Parcel1().new Destination(dest);
		System.out.println(d.readLabel());
	}
	public static void main(String[] args) {
		Parcel1.ship("test");
	}
	
}
