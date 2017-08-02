package designPattern.headfirst.chapter_08TemplateMethod.anExample;

public class Coffee extends CaffeineBeverage {

	@Override
	void brew() {
		System.out.println("Dripping coffee!");
	}

	@Override
	void addCondiments() {
		System.out.println("Adding sugar and milk!");
	}

}
