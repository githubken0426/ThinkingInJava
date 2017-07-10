package designPattern.headfirst.chapter_04Factory.anExample.abstractFactory;

import designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.ingredentFactory.PizzaIngredientFactory;
/**
 * 奶酪披萨
 * marker#2抽象工厂使用的是对象(组合)PizzaIngredientFactory
 * @author ken
 * 
 * @date 2017年7月10日 下午3:37:04
 */
public class CheesePizza extends Pizza {
	private PizzaIngredientFactory factory;
	
	public CheesePizza(PizzaIngredientFactory factory){
		this.factory=factory;
	}
	
	@Override
	public void prepare() {
		System.out.println("preparing "+name);
		dough=factory.createDough();
		cheese=factory.createCheese();
		sauce=factory.createSauce();
	}

}
