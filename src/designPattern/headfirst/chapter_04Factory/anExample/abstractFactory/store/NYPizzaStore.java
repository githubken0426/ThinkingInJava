package designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.store;

import designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.CheesePizza;
import designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.Pizza;
import designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.VeggiePizza;
import designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.ingredentFactory.NYPizzaIngredientFactory;
import designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.ingredentFactory.PizzaIngredientFactory;

/**
 * 纽约披萨店
 * @author ken
 * 
 * @date 2017年7月10日 下午3:28:30
 */
public class NYPizzaStore extends PizzaStore{

	@Override
	public Pizza createPizza(String type) {
		Pizza pizza=null;
		PizzaIngredientFactory factory=new NYPizzaIngredientFactory();
		if(type.equals("cheese")){
			pizza= new CheesePizza(factory);
			pizza.setName("纽约cheese披萨！");
		}else if(type.equals("veggie")){
			pizza= new VeggiePizza(factory);
			pizza.setName("纽约veggie披萨！");
		}
		return pizza;
	}

}
