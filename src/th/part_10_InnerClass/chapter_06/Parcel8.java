package th.part_10_InnerClass.chapter_06;

/**
 * 匿名内部类
 * 
 * @author ken 2016-9-20 下午02:22:16
 */
public class Parcel8 {
	class Wrapping {
		private int i;
		public Wrapping(int x) {
			i = x;
		}
		public int value() {
			return i;
		}
	}
	/**
	 * wrapping()中的匿名实现，
	 * 尽管Wrapping是一个具体实现，
	 * 但此处Wrapping相当于继承或接口实现
	 * @param val
	 * @return
	 * 2016-9-20 下午03:00:21
	 */
	public static Wrapping wrapping(int val) {
		return new Parcel8().new Wrapping(val) {
			public int value() {
				return super.value() * 47;
			}
		};
	}

	public static void main(String[] args) {
		System.out.println(Parcel8.wrapping(100).value());
	}
}
