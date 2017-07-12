package designPattern.headfirst.chapter_03Decorator.anExample.decorator;

import designPattern.headfirst.chapter_03Decorator.anExample.beverage.Beverage;

public class Soy extends CondimentDecorator {
	Beverage beverage;

	public Soy(Beverage beverage) {
		description = "soy";
		this.beverage = beverage;
	}

	@Override
	public double cost() {
		return 1.0 + beverage.cost();
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ",Soy";
	}
}
