package designPattern.headfirst.chapter_04Factory.anExample.abstractFactory;

import designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.store.ChicagoPizzaStore;
import designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.store.NYPizzaStore;
import designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.store.PizzaStore;

public class Test {
	public static void main(String[] args) {
		PizzaStore store=new NYPizzaStore();
		store.orderPizza("cheese");
		
		store=new ChicagoPizzaStore();
		store.orderPizza("veggie");
	}
}
