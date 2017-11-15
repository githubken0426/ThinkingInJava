package th.part_14_TypeInfo._extendsT;

import java.util.*;

public class DemosMain {
	/**
	 * 但我们不知道这个子类型究竟是什么。因为没法确定，
	 * 为了保证类型安全，我们就不允许往里面加入任何这种类型的数据
	 * @param args
	 */
	public static void main(String[] args) {
		List<? extends Fruit> fruit=new ArrayList<Fruit>();
//		fruit.add(new Fruit());
//		fruit.add(new Apple());
//		fruit.add(new RedApple());
		fruit.add(null);
		
		List<Apple> apples = new ArrayList<Apple>();
		//编译通过
		List<? extends Fruit> app=apples;
		//不能add,可以通过反射给他注入值
		//app.add(new RedApple());
		List<Class<? extends Fruit>> reflact=Collections.unmodifiableList(
				Arrays.asList(Fruit.class,Apple.class,RedApple.class));
	}
}
