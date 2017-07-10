package designPattern.headfirst.chapter_04Factory.anExample.abstractFactory;

import designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.ingredentFactory.PizzaIngredientFactory;

/**
 * 素食披萨
 * @author ken
 * 
 * @date 2017年7月10日 下午3:36:31
 */
public class VeggiePizza extends Pizza {

	private PizzaIngredientFactory factory;
	public VeggiePizza(PizzaIngredientFactory factory){
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
