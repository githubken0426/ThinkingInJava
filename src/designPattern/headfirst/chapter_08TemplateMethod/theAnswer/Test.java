package designPattern.headfirst.chapter_08TemplateMethod.theAnswer;

public class Test {
	public static void main(String[] args) {
		CaffeineBeverageWithHook coffee=new CaffeineWithHook();
		coffee.prepare();
	}
}
