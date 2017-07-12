package designPattern.headfirst.chapter_04Factory.abstractFactory.ingredentFactory;

import designPattern.headfirst.chapter_04Factory.abstractFactory.ingredent.Cheese;
import designPattern.headfirst.chapter_04Factory.abstractFactory.ingredent.Dough;
import designPattern.headfirst.chapter_04Factory.abstractFactory.ingredent.Sauce;

/**
 * 抽象工厂
 * 创建产品的方法通常是以"工厂方法"来实现的。
 * @author ken
 * 
 * @date 2017年7月10日 下午2:56:08
 */
public interface PizzaIngredientFactory {
	public Dough createDough();
	public Cheese createCheese();
	public Sauce createSauce();
}
