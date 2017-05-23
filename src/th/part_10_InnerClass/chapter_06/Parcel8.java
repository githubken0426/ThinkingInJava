package th.part_10_InnerClass.chapter_06;

/**
 * �����ڲ���
 * 
 * @author ken 2016-9-20 ����02:22:16
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
	 * wrapping()�е�����ʵ�֣�
	 * ����Wrapping��һ������ʵ�֣�
	 * ���˴�Wrapping�൱�ڼ̳л�ӿ�ʵ��
	 * @param val
	 * @return
	 * 2016-9-20 ����03:00:21
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
