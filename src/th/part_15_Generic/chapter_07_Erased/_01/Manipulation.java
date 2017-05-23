package th.part_15_Generic.chapter_07_Erased._01;

public class Manipulation {
	public static void main(String[] args) {
		HasF hasf=new HasF();
		Manipulator<HasF> manipulator=new Manipulator<HasF>(hasf);
		manipulator.manipulator();
		
		Manipulator2<HasF> manipulator2=new Manipulator2<HasF>(hasf);
		manipulator2.manipulator2();
	}
}
