package designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.ingredentFactory;

import designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.ingredent.Cheese;
import designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.ingredent.Dough;
import designPattern.headfirst.chapter_04Factory.anExample.abstractFactory.ingredent.Sauce;

/**
 * 抽象工厂
 * @author ken
 * 
 * @date 2017年7月10日 下午2:56:08
 */
public interface PizzaIngredientFactory {
	public Dough createDough();
	public Cheese createCheese();
	public Sauce createSauce();
}
