package th.part_10_InnerClass.chapter_03;

/**
 * 嵌套类(内部静态类)
 * @author Administrator
 *
 * 2016-9-20 上午08:51:01
 */
public class Parcel3 {
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
	
	public static void main(String[] args) {
		Parcel3 par=new Parcel3();
		Parcel3.Contents con=par.new Contents();
		System.out.println(con);
		Parcel3.Destination des=par.new Destination("Destination");
		System.out.println(des.readLabel());
	}
}
