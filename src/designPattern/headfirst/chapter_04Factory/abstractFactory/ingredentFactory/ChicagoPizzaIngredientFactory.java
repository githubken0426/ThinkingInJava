package designPattern.headfirst.chapter_04Factory.abstractFactory.ingredentFactory;

import designPattern.headfirst.chapter_04Factory.abstractFactory.ingredent.Cheese;
import designPattern.headfirst.chapter_04Factory.abstractFactory.ingredent.Dough;
import designPattern.headfirst.chapter_04Factory.abstractFactory.ingredent.Sauce;
import designPattern.headfirst.chapter_04Factory.abstractFactory.ingredent.chicago.ChicagoCheese;
import designPattern.headfirst.chapter_04Factory.abstractFactory.ingredent.chicago.ChicagoDough;
import designPattern.headfirst.chapter_04Factory.abstractFactory.ingredent.chicago.ChicagoSauce;
/**
 * 芝加哥原料工厂
 * @author ken
 * 
 * @date 2017年7月10日 下午3:14:57
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		System.out.println("添加芝加哥风味面团");
		return new ChicagoDough();
	}

	@Override
	public Cheese createCheese() {
		System.out.println("添加芝加哥风味奶酪");
		return new ChicagoCheese();
	}

	@Override
	public Sauce createSauce() {
		System.out.println("添加芝加哥风味酱");
		return new ChicagoSauce();
	}

}
