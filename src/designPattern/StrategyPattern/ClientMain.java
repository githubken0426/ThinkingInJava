package designPattern.StrategyPattern;

public class ClientMain {
	/**
	 * 策略模式应用场景：
	 * 1、 多个类只区别在表现行为不同，可以使用Strategy模式，在运行时动态选择具体要执行的行为。
	 * 2、 需要在不同情况下使用不同的策略(算法)，或者策略还可能在未来用其它方式来实现。
	 * 3、 对客户隐藏具体策略(算法)的实现细节，彼此完全独立。
	 * @param args
	 */
	public static void main(String[] args) {
		MemberStrategy strategy=new PrimaryMember();
		Price price=new Price(strategy);
		System.out.println(price.quote(100));
		
		Price p=new Price(new MemberStrategy(){//也可以传入PrimaryMember对象，但是方法可以不用重写
			@Override
			public double calcPrice(double bookPrice) {
				System.out.println("我是价格:"+bookPrice);
				return bookPrice;
			}
		});
		System.out.println(p.quote(100));
	}
}
