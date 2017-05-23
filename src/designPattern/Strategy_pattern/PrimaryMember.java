package designPattern.Strategy_pattern;

/**
 * 具体策略角色：包装了相关的算法和行为
 * 初级会员
 * @author Administrator
 * 2015-11-20 11:37:09
 *
 */
public class PrimaryMember implements MemberStrategy{

	@Override
	public double calcPrice(double bookPrice) {
		System.out.println("初级会员没有折扣!");
		return bookPrice;
	}
}
