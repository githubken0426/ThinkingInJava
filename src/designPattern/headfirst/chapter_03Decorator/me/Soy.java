package designPattern.headfirst.chapter_03Decorator.me;

public class Soy extends CondimentDecorator {
	Beverage beverage;

	public Soy(Beverage beverage) {
		description = "soy";
		this.beverage = beverage;
	}

	@Override
	public double cost() {
		double discount = getDiscount();
		return 1 * discount + beverage.cost() * discount;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ",Soy";
	}
}
