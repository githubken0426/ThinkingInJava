package designPattern.Strategy_pattern;

/**
 * ������ɫ������һ������������ã����ո��ͻ��˵���
 * @author Administrator
 * 2015-11-23 ����08:46:15
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
