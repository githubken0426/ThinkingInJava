package jdk8;

public class Lambda {
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();
		
	}
}
