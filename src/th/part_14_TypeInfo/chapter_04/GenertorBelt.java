package th.part_14_TypeInfo.chapter_04;

public class GenertorBelt extends Belt {
	public static class Factory_GenertorBelt implements Factory<GenertorBelt> {
		@Override
		public GenertorBelt create() {
			return new GenertorBelt();
		}
	}
}
