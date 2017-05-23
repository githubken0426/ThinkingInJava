package th.part_14_TypeInfo.exercise;

import th.part_14_TypeInfo.chapter_02._01.FancyToy;

public class SuperToy extends FancyToy {
	int iq;
	
	public SuperToy(int iq){
		this.iq=iq;
	}
	
	public String toString(){
		return "I am SuperToy,i am smarter than you!";
	}
}
