package th.part_07_encapsulation.chapter_08;

public abstract class Glyph {
	
	abstract void draw();

	Glyph() {
		System.out.println("Glyph() before draw()");
		draw();
		System.out.println("Glyph() after draw()");
	}
}
