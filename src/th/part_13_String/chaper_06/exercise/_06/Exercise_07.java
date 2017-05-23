package th.part_13_String.chaper_06.exercise._06;

public class Exercise_07 {
	public static void main(String[] args) {
		String str="I s that a dog.";
		//[A-Z].*\\.
		System.out.println(str.matches("\\p{Upper}.*\\."));
	}
}
