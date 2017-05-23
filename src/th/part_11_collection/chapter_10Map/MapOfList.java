package th.part_11_collection.chapter_10Map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import th.part_11_collection.chapter_06Iterator.PetsA;

public class MapOfList {
	public static Map<Person,List<? extends PetsA>> petPeople =
			new HashMap<Person,List<? extends PetsA>>();
	static{
		petPeople.put(new Person("Down"),Arrays.asList(
				new Cymric("Molly"),new Mutt("Spot")));
		petPeople.put(new Person("Kate"),Arrays.asList(
				new Cat("Elise May"),new Cat("Shackleton"),new Dog("Margreet")));
	}
	
	public static void main(String[] args) {
		Scanner input=new Scanner (System.in);
		System.out.println("«Î ‰»Î–’√˚");
		String name=input.next();
		System.out.println("people:"+petPeople.keySet());
		System.out.println("pets:"+petPeople.values());
		for (Person person : petPeople.keySet()) {
			System.out.println(person.getName()+" has pets:");
			for(PetsA pet:petPeople.get(person)){
				System.out.println(pet.getName());
			}
		}
	}
}
