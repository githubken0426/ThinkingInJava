package th.part_12_exception.chapter_01.exercise._05;

public class Resumtion_05 {
	public static void main(String[] args) {
		while(true){
			try {
				Resumer_05.f();
			} catch (Exception e) {
				System.out.println("Cought:"+e);
				continue;
			}
			System.out.println("Go though");
			break;
		}
		System.out.println("successfull");
	}
}	
