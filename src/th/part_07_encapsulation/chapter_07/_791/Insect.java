package th.part_07_encapsulation.chapter_07._791;

public class Insect {
	private int i=9;
	protected int j;
	Insect(){
		System.out.println("i="+i+",j="+j);
		j=39;
	}
	private static int x1=print("static Insect.x1 initialized!");
	static int print(String str) {
		System.out.println(str);
		return 47;
	}
}
