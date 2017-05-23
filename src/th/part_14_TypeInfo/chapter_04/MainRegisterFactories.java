package th.part_14_TypeInfo.chapter_04;

public class MainRegisterFactories {

	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			System.out.println(Part.createRandom());
		}
	}

}
