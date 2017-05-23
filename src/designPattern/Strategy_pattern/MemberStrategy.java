package designPattern.Strategy_pattern;

/**
 * 抽象策略角色： 策略类，通常由一个接口或者抽象类实现。
 * 会员策略
 * 算法一：对初级会员没有折扣。
 * 算法二：对中级会员提供10%的促销折扣。
 * 算法三：对高级会员提供20%的促销折扣。
 * @author Administrator
 * 2015-11-20 上午11:33:14
 *
 */

public interface MemberStrategy {
	/**
	 * 方法:计算价格
	 * @param bookPrice 原价
	 * @return 折后价
	 */
	public double calcPrice(double bookPrice);
	
}
