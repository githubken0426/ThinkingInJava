package th.part_10_InnerClass.chapter_04;

public class Parcel4 {
	private class ContentsImpl implements Contents{
		private int i=11;
		@Override
		public int value() {
			return i;
		}
	}
	/**
	 * protectedȨ�ޣ�ֻ��Parcel4�������ࡢͬ���е����з���Ȩ��
	 * 
	 * @author ken
	 * 2016-9-20 ����01:56:50
	 */
	protected class DestinationImpl implements Destination{
		private String label;
		private DestinationImpl(String label){
			this.label=label;
		}
		@Override
		public String readLabel() {
			return label;
		}
	}
	
	public Destination destination(String s){
		return new DestinationImpl(s);
	}
	
	public Contents contents(){
		return new ContentsImpl();
	}
}
