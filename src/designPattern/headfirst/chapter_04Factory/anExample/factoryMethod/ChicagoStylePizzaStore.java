package designPattern.headfirst.chapter_04Factory.anExample.factoryMethod;

import org.apache.commons.lang.StringUtils;

public class ChicagoStylePizzaStore extends PizzaStore {
	
	@Override
	protected Pizza createPizza(String type) {
		if(!StringUtils.isNotBlank(type))
			throw new UnsupportedOperationException();
		if(type.equals("cheese"))
			return new ChicagoStyleCheesePizza();
		return null;
	}

}
