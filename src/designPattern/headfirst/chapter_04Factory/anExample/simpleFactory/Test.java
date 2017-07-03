package designPattern.headfirst.chapter_04Factory.anExample.simpleFactory;

/**
 * 简单模式
 * @author ken
 * 
 * @date 2017年6月27日 下午3:32:38
 * 
 */
public class Test {
	public static void main(String[] args) {
		PizzaStore nyStyle=new PizzaStore(new SimplePizzaFactory());
		nyStyle.orderPizza("cheese");
	}
	
}
