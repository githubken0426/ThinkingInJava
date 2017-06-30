package designPattern.headfirst.chapter_04Factory.anExample;
/**
 * PizzaStore为一个超类型
 * 让子类来实现具体的Pizza制作方法
 * @author ken
 * 
 * @date 2017年6月27日 下午3:48:22
 */
public abstract class PizzaStore {
	/**
	 * 工厂方法，用来创建产品
	 * @param type
	 * @return
	 * @date 2017年6月27日 下午5:46:02
	 */
	protected abstract Pizza createPizza(String type);
	
	public final Pizza orderPizza(String type){
		Pizza pizza=createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
