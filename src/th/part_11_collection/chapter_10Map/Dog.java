package th.part_11_collection.chapter_10Map;

import th.part_11_collection.chapter_06Iterator.PetsA;

public class Dog extends PetsA {
	private String name;
	
	public Dog(){}
	public Dog(String name){
		super();
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
