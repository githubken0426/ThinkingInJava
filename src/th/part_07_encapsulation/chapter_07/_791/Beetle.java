package th.part_07_encapsulation.chapter_07._791;

public class Beetle extends Insect {
	private int k =print("Beetle.k initialized!");
	public Beetle(){
		System.out.println("k="+k);
		System.out.println("j="+j);
	}
	
	private static int x2=print("static Beetle.x2 initialized!");
	
	public static void main(String[] args) {
		System.out.println("Beetle constructor");
		Beetle b=new Beetle();
	}
}
