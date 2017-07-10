package designPattern.headfirst.chapter_04Factory.anExample.factoryMethod;

/**
 * marker#1工厂方法使用的是类(继承)
 */
public class ChicagoStyleCheesePizza implements Pizza {
	@Override
	public void prepare() {
		System.out.println("Chicago CheesePizza prepare");
	}

	@Override
	public void bake() {
		System.out.println("bake");
	}

	@Override
	public void cut() {
		System.out.println("cut");
	}

	@Override
	public void box() {
		System.out.println("box");
	}
}
