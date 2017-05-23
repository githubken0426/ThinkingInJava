package th.part_14_TypeInfo.chapter_03._01.Rodent;

import th.part_14_TypeInfo.chapter_03._01.Pet;

public class Rodent extends Pet {
	public Rodent(){
		super();
	}
	
	public Rodent(String name){
		super(name);
	}
	
	public void test(){
		System.out.println("Rodent!");
	}
}
