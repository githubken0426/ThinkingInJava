package designPattern.headfirst.chapter_04Factory.abstractFactory.ingredentFactory;

import designPattern.headfirst.chapter_04Factory.abstractFactory.ingredent.Cheese;
import designPattern.headfirst.chapter_04Factory.abstractFactory.ingredent.Dough;
import designPattern.headfirst.chapter_04Factory.abstractFactory.ingredent.Sauce;
import designPattern.headfirst.chapter_04Factory.abstractFactory.ingredent.ny.NYCheese;
import designPattern.headfirst.chapter_04Factory.abstractFactory.ingredent.ny.NYDough;
import designPattern.headfirst.chapter_04Factory.abstractFactory.ingredent.ny.NYSauce;
/**
 * 纽约原料工厂
 * @author ken
 * 
 * @date 2017年7月10日 下午3:14:25
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		System.out.println("添加纽约风味面团");
		return new NYDough();
	}

	@Override
	public Cheese createCheese() {
		System.out.println("添加纽约风味奶酪");
		return new NYCheese();
	}

	@Override
	public Sauce createSauce() {
		System.out.println("添加纽约风味酱");
		return new NYSauce();
	}

}
