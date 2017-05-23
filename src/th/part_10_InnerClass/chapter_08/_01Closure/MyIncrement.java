package th.part_10_InnerClass.chapter_08._01Closure;

public class MyIncrement {
	public void increment(){
		System.out.println("MyIncrement.increment()!");
	}
	
	static void f(MyIncrement mi){
		mi.increment();
	}
}
