package designPattern.headfirst.chapter_08TemplateMethod.anExample;

public class Test {
	public static void main(String[] args) {
		CaffeineBeverage caffeine=new Tea();
		caffeine.prepare();
		
		System.out.println();
		caffeine=new Coffee();
		caffeine.prepare();
	}
}
