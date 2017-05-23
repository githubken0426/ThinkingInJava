package th.part_14_TypeInfo.chapter_02._02;

public class Initable3 {
	static int staticNoFinal = 74 ; 
	static {
		System. out .println( "Initialization Initable 3" );
	}
	public Initable3(){
		System.out.println("Initable3构造器!");
	}
}
