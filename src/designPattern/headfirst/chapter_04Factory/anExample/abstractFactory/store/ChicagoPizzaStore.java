package designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.store;

import designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.CheesePizza;
import designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.Pizza;
import designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.VeggiePizza;
import designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.ingredentFactory.ChicagoPizzaIngredientFactory;
import designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.ingredentFactory.PizzaIngredientFactory;

/**
 * 芝加哥披萨店
 * @author ken
 * 
 * @date 2017年7月10日 下午3:28:30
 */
public class ChicagoPizzaStore extends PizzaStore{

	/**
	 * 此方法使用了工厂方法
	 */
	@Override
	public Pizza createPizza(String type) {
		Pizza pizza=null;
		PizzaIngredientFactory factory=new ChicagoPizzaIngredientFactory();
		if(type.equals("cheese")){
			pizza= new CheesePizza(factory);
			pizza.setName("芝加哥cheese披萨！");
		}else if(type.equals("veggie")){
			pizza= new VeggiePizza(factory);
			pizza.setName("芝加哥veggie披萨！");
		}
		return pizza;
	}

}
