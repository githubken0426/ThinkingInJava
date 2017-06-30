package designPattern.headfirst.chapter_04Factory.anExample;

/**
 * 简单工厂
 * @author ken
 * 
 * @date 2017年6月27日 下午3:32:38
 */
public class Test {
	public static void main(String[] args) {
		PizzaStore nyStyle=new NYStylePizzaStore();
		nyStyle.orderPizza("cheese");
		
		PizzaStore chicago=new ChicagoStylePizzaStore();
		chicago.orderPizza("cheese");
	}
	
}
