package designPattern.headfirst.chapter_03Decorator.anExample.decorator;

import designPattern.headfirst.chapter_03Decorator.anExample.beverage.Beverage;

/**
 * 具体的装饰者
 * 
 * @author ken 2017-6-15 pm 03:08:04
 */
public class Mocha extends CondimentDecorator {
	Beverage beverage;

	public Mocha(Beverage beverage) {
		description = "mocha";
		this.beverage = beverage;
	}

	@Override
	public double cost() {
		return 1.0 + beverage.cost();
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ",Mocha";
	}

}
