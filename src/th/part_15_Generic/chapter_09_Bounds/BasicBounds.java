package th.part_15_Generic.chapter_09_Bounds;

public class BasicBounds {
	/**
	 * BasicBounds������������ļ̳�
	 * @param args
	 */
	public static void main(String[] args) {
		Solid<Bounded> solid = new Solid<Bounded>(new Bounded());
		solid.color();
		solid.weight();
		solid.getX();
	}
}
