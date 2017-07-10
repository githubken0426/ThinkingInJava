package designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.store;

import designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.Pizza;

public abstract class PizzaStore {
	public abstract Pizza createPizza(String type);
	
	public final Pizza orderPizza(String type){
		Pizza pizza=createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
