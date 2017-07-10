package designPattern.headfirst.chapter_04Factory.anExample.abstractFactory;

import designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.store.ChicagoPizzaStore;
import designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.store.NYPizzaStore;
import designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.store.PizzaStore;

/**
 * 工厂方法使用的是类(继承)
 * 抽象工厂使用的是对象(组合)
 * @author ken
 * 
 * @date 2017年7月10日 下午4:21:21
 */
public class Test {
	public static void main(String[] args) {
		PizzaStore store=new NYPizzaStore();
		store.orderPizza("cheese");
		
		store=new ChicagoPizzaStore();
		store.orderPizza("veggie");
	}
}
