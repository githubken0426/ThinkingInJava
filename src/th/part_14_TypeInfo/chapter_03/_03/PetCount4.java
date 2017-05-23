package th.part_14_TypeInfo.chapter_03._03;

import th.part_14_TypeInfo.chapter_03._01.ForNameCreator;
import th.part_14_TypeInfo.chapter_03._01.Pet;

public class PetCount4 {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		TypeCounter count=new TypeCounter(Pet.class);
		for(Pet pet: ForNameCreator.class.newInstance().createArray(5)){
			System.out.println(pet.getClass().getSimpleName());
			count.count(pet);
		}
		System.out.println(count);
	}
}
