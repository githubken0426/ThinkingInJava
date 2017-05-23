package th.part_10_InnerClass.chapter_01;
/**
 * 10.1 创建内部类
 * @author Administrator
 *
 * 2016-9-19 上午11:45:13
 * [pɑ:rsl] 包袱，包裹
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
