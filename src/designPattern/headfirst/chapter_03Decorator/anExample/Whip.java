package designPattern.headfirst.chapter_03Decorator.anExample;

public class Whip extends CondimentDecorator {
	Beverage beverage;

	public Whip(Beverage beverage) {
		description = "whip";
		this.beverage = beverage;
	}

	@Override
	public double cost() {
		return 1.0 + beverage.cost();
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ",Whip";
	}
}