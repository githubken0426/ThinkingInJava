package designPattern.headfirst.chapter_04Factory.anExample;

import org.apache.commons.lang.StringUtils;

import designPattern.headfirst.chapter_04Factory.factoryMethod.NYStyleCheesePizza;
import designPattern.headfirst.chapter_04Factory.factoryMethod.Pizza;

/**
 * 简单工厂
 * @author ken
 * 
 * @date 2017年7月3日 下午5:44:04
 */
public class SimplePizzaFactory {
	public Pizza createPizza(String type) {
		if(StringUtils.isBlank(type))
			throw new UnsupportedOperationException();
		if(type.equals("cheese"))
			return new NYStyleCheesePizza();
		if(type.equals("other"))
			return null;
		return null;
	}
}
