package th.part_14_TypeInfo.chapter_03._01.Rodent;

public class Mouse extends Rodent {
	public Mouse(){
		super();
	}
	
	public Mouse(String name){
		super(name);
	}
	
	@Override
	public void test(){
		System.out.println("Mouse!");
	}
}
