package designPattern.headfirst.chapter_03Decorator.anExample.decorator;

import designPattern.headfirst.chapter_03Decorator.anExample.beverage.Beverage;

/**
 * 抽象装饰者
 * 
 * @author ken
 * 2017-6-15 下午02:56:49
 */
public abstract class CondimentDecorator extends Beverage {
	
	public abstract double cost();
	
	public abstract String getDescription();
}
