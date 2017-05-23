package th.part_11_collection.chapter_10Map;

import th.part_11_collection.chapter_06Iterator.PetsA;

public class Cat extends PetsA {
	private String name;
	
	public Cat(){}
	public Cat(String name){
		super(name);
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
