package th.part_10_InnerClass.chapter_01;

public class Parcel2 {
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
	
	public static Destination to(String s){
		return new Parcel2().new Destination(s);
	}
	public static Contents contents(){
		return new Parcel2().new Contents();
	}
	
	public static void ship(){
		Destination d=to("test");
		System.out.println(d.readLabel());
	}
	
	public static void main(String[] args) {
		Parcel2.ship();
		Destination d=Parcel2.to("abc");
		System.out.println(d.readLabel());
	}
}
