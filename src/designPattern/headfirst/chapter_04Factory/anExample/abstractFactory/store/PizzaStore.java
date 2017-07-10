package designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.store;

import designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.Pizza;

public abstract class PizzaStore {
	/**
	 * 提供一个抽象借口来创建产品
	 * 
	 * @param type
	 * @return
	 * @date 2017年7月10日 下午4:52:43
	 */
	public abstract Pizza createPizza(String type);
	/**
	 * PizzaStore实现为工厂方法。
	 */
	public final Pizza orderPizza(String type){
		Pizza pizza=createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
