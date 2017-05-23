package th.part_14_TypeInfo.chapter_04;

public class FuelFilter extends Filter {
	
	public static class Factory_FuelFilter implements th.part_14_TypeInfo.chapter_04.Factory<FuelFilter> {
		@Override
		public FuelFilter create() {
			return new FuelFilter();
		}

	}
}
