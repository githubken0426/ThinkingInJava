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
		 * ˽�й����޷����ⲿ��̳У�
		 * �ڲ��౻�ⲿ��̳У��ⲿ���������ʽ�����ڲ��๹�캯��
		 * ����д�Ĺ��캯������������ڲ����ϼ������.�μ�:Parcel5
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
