package th.part_14_TypeInfo.chapter_02._01;

public class GetClass {
	public interface HasBatteries{}
	public interface Waterproof{}
	public interface Shoots{}
	/**
	 * 默认构造器必须有
	 * You must define the required default constructor for up.newInstance( ); the
	   compiler can’t create it because a non-default constructor already exists.
	 * @author Administrator
	 *
	 */
	public static class Toy{
		private String toyName;
		public String getToyName() {
			return toyName;
		}
		public void setToyName(String toyName) {
			this.toyName = toyName;
		}
		public Toy(){}
		public Toy(int i){}
	}
}
