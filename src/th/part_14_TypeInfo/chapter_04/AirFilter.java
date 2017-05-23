package th.part_14_TypeInfo.chapter_04;


public class AirFilter extends Filter {
	public static class Factory_AirFilterr implements Factory<AirFilter> {
		@Override
		public AirFilter create() {
			return new AirFilter();
		}
	}
}
