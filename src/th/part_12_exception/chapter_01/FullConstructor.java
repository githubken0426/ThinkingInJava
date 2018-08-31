package th.part_12_exception.chapter_01;

public class FullConstructor {
	
	public static void f() throws MyException{
		System.out.println("throw MyException ");
		throw new MyException();
	}
	
	public static void main(String[] args){
		try {
			FullConstructor.f();
		} catch (MyException e) {
			e.printStackTrace(System.out);
		}
	}
}
