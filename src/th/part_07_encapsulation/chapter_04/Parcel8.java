package th.part_07_encapsulation.chapter_04;

import th.part_07_encapsulation.chapter_06.Destination;

public class Parcel8 {
	// 参数要求外部对象为final
	// anonymous class 匿名类
	//inner class:内部类
	//anonymous inner class:匿名内部类
	public Destination dest(final String dest) {
		System.out.println(dest);
		
		return new Destination() {
			private String label = dest;
			public String readLabel() {
				return label;
			}
		};
	}

	public static void main(String[] args) {
		Parcel8 p = new Parcel8();
		Destination d = p.dest("Tanzania");
	}
}
