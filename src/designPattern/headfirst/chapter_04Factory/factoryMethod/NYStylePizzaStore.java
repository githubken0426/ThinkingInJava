package designPattern.headfirst.chapter_04Factory.factoryMethod;

import org.apache.commons.lang.StringUtils;

public class NYStylePizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza(String type) {
		if(!StringUtils.isNotBlank(type))
			throw new UnsupportedOperationException();
		if(type.equals("cheese"))
			return new NYStyleCheesePizza();
		return null;
	}

}
