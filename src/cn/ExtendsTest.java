package cn;

public class ExtendsTest {
	static class A{
		static {
			System.out.println("A的静态块");
		}
		A(){
			System.out.println("A的构造");
		}
	}
	static class B extends A{
		static {
			System.out.println("B的静态块");
		}
		B(){
			System.out.println("B的构造");
		}
	}
	
	public static void main(String[] args) {
		B b =new B();
	}
}
