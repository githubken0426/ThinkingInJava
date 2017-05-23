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
	 * protected权限，只有Parcel4、其子类、同包中的类有访问权限
	 * 
	 * @author ken
	 * 2016-9-20 下午01:56:50
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
