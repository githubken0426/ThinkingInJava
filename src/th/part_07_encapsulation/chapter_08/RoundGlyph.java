package th.part_07_encapsulation.chapter_08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RoundGlyph extends Glyph {
	int radius = 1;

	RoundGlyph(int r) {
		radius = r;
		System.out.println("RoundGlyph�Ĺ��캯��, radius = " + radius);
	}

	@Override
	void draw() {
		System.out.println("RoundGlyph.draw()����, radius = " + radius);
	}
	
	public static void main(String[] args) {
		new RoundGlyph(5);
	}

}
