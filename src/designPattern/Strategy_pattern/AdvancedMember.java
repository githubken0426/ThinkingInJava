package designPattern.Strategy_pattern;

/**
 * 具体策略角色：包装了相关的算法和行为
 * 高级会员
 * @author Administrator
 * 2015-11-20 11:40:36
 *
 */
public class AdvancedMember implements MemberStrategy{
	@Override  
	public double calcPrice(double bookPrice) {
		System.out.println("高级会员享受8折优惠！");
		return bookPrice*0.8;
	}
}
