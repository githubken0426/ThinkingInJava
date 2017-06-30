package designPattern.headfirst.chapter_04Factory.anExample;

public class ChicagoStyleCheesePizza implements Pizza {
	@Override
	public void prepare() {
		System.out.println("Chicago CheesePizza prpare");
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
