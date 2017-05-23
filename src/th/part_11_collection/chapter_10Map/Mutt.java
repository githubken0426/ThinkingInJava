package th.part_11_collection.chapter_10Map;

import th.part_11_collection.chapter_06Iterator.PetsA;

public class Mutt extends PetsA {
	private String name;
	
	public Mutt(){}
	public Mutt(String name){
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
