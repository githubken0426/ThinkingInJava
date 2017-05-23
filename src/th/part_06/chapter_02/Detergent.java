package th.part_06.chapter_02;

import java.util.Vector;

public class Detergent extends Cleanser {
	public void scrub() {
		append(" Detergent.scrub()");
		super.scrub(); //Call base-class version
	}

	public void foam() {
		append(" foam()");
	}
	
	
	public static void main(String[] args) {
		Vector v=new Vector();
		Detergent x = new Detergent();
		x.getAll();
		x.scrub();
		x.foam();
		System.out.println("Testing base class x.s:"+x.s);
		Cleanser.main(args);
	}
}
