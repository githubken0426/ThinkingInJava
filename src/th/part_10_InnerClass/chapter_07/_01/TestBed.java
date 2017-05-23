package th.part_10_InnerClass.chapter_07._01;

public class TestBed {
	static void f(){
		System.out.println("f()");
	}
	public static class Tester{
		public static void main(String[] args) {
			System.out.println(Tester.class);
			TestBed.f();
		}
	}
}
