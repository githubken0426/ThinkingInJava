package designPattern.StrategyPattern;

/**
 * 环境角色：持有一个策略类的引用，最终给客户端调用
 * @author Administrator
 * 2015-11-23 上午08:46:15
 *
 */
public class Price {
	private MemberStrategy strategy;
	
	public Price(MemberStrategy strategy){
		this.strategy=strategy;
	}
	
	public double quote(double bookPrice){
		return this.strategy.calcPrice(bookPrice);
	}
}
