package th.part_14_TypeInfo.chapter_03._01.Rodent;

public class Hamster extends Rodent {
	public Hamster(){
		super();
	}
	public Hamster(String name){
		super(name);
	}
	
	@Override
	public void test(){
		System.out.println("Hamster!");
	}
}
