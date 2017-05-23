package th.part_19_ENUM.chapter_06_Random;

public class RandomTest {
	public static void main(String[] args) {
		for(int i=0;i<20;i++){
			System.out.println(Enums.random(Activity.class)+" ");
		}
	}
}
