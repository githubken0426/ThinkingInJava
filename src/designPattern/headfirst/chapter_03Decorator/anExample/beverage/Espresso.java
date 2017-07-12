package designPattern.headfirst.chapter_03Decorator.anExample.beverage;
/**
 * 具体组件
 * @author ken
 * 
 * @date 2017年7月12日 下午2:48:05
 */
public class Espresso extends Beverage {
	public Espresso() {
		description = "Espresso";
	}

	@Override
	public double cost() {
		return 2.9;
	}
}
