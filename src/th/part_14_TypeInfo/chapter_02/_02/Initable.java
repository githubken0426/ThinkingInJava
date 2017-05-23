package th.part_14_TypeInfo.chapter_02._02;

public class Initable {
	static final int staticFinal = 47 ; 
	//使用static final修饰变量，并不能保证使其成为一个编译期常量，如:staticFinal2
	static final int staticFinal2 = ClassInitialization.rand.nextInt( 100 ); 
	static { 
		System. out .println( "static静态块：Initialization Initable1" ); 
		}
	public Initable(){
		System.out.println("Initable1构造器");
	}
}
