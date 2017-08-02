package designPattern.headfirst.chapter_08TemplateMethod.anExample;

public abstract class CaffeineBeverage {
	final void prepare() {
		boilWater();
		brew();
		addCondiments();
		pourInCup();
	}
	
	abstract void brew();
	abstract void addCondiments();
	
	void boilWater() {
		System.out.println("boiling water!");
	}
	void pourInCup() {
		System.out.println("Pouring into cup!");
	}
}
