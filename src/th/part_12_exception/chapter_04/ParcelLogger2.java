package th.part_12_exception.chapter_04;

import th.part_12_exception.chapter_01.MyException2;


public class ParcelLogger2 {
	public static void f()throws MyException2{
		System.out.println("thwor MyExcepton2:");
		throw new  MyException2();
	}
	public static void g()throws MyException2{
		System.out.println("thwor MyExcepton2:");
		throw new  MyException2("method g()");
	}
	public static void h()throws MyException2{
		System.out.println("thwor MyExcepton2:");
		throw new  MyException2("method h()",4);
	}
	
	public static void main(String[] args) {
		try {
			f();
		} catch (MyException2 e) {
			e.printStackTrace(System.out);
		}
		
		try {
			g();
		} catch (MyException2 e) {
			e.printStackTrace(System.out);
		}
		try {
			h();
		} catch (MyException2 e) {
			e.printStackTrace(System.out);
			System.out.println("e.val():"+e.value());
		}
	}

}
