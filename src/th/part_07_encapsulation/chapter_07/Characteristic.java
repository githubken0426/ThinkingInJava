package th.part_07_encapsulation.chapter_07;

public class Characteristic {
	String s;

	Characteristic(String c) {
		s = c;
		System.out.println("Creating Characteristic " + s);
	}

	protected void finalize() {
		System.out.println("finalizing Characteristic " + s);
	}
}
