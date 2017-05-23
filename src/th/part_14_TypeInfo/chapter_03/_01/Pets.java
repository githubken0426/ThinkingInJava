package th.part_14_TypeInfo.chapter_03._01;

import java.util.ArrayList;

public class Pets {
	public final static PetCreator creator=new LiteralPetCreator();
	
	public static Pet randomPet() {
		return creator.randomPet();
	}

	public static Pet[] createArray(int size) {
		return creator.createArray(size);
	}

	public static ArrayList<Pet> arrayList(int size) {
		return creator.arrayList(size);
	}
}
