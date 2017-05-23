package th.part_14_TypeInfo.chapter_04;

public class FanlBelt extends Belt {
	public static class Factory_FanlBelt implements Factory<FanlBelt> {
		@Override
		public FanlBelt create() {
			return new FanlBelt();
		}
	}
}
