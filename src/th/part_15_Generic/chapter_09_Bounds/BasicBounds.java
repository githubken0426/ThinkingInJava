package th.part_15_Generic.chapter_09_Bounds;

public class BasicBounds {
	/**
	 * BasicBounds可以消除冗余的继承
	 * @param args
	 */
	public static void main(String[] args) {
		Solid<Bounded> solid = new Solid<Bounded>(new Bounded());
		solid.color();
		solid.weight();
		solid.getX();
	}
}
