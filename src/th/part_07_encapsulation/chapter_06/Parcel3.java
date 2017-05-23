package th.part_07_encapsulation.chapter_06;

public class Parcel3 {

	private class PContents extends Contents {
		private int i = 11;

		public int value() {
			return i;
		}
	}

	protected class PDestination implements Destination {
		private String label;
		/**
		 * 私有构造无法被外部类继承，
		 * 内部类被外部类继承，外部子类必须显式调用内部类构造函数
		 * 且重写的构造函数，必须包含内部类上级类参数.参见:Parcel5
		 * @param label
		 */
		public PDestination(String label) {
			this.label = label;
		}

		public String readLabel() {
			return label;
		}
	}

	public Destination dest(String s) {
		return new PDestination(s);
	}

	public Contents cont() {
		return new PContents();
	}
}
