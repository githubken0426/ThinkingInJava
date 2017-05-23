package th.part_14_TypeInfo.chapter_02._02;

public class Initable2 {
	static int staticNoFinal = 147 ; 
	static { 
		System. out .println( "Initialization Initable2" );
	}
	public Initable2(){
		System. out .println( "Initable2构造器" );
	}
}
