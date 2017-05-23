package designPattern.Strategy_pattern;

/**
 * 具体策略角色：包装了相关的算法和行为
 * 中级会员
 * @author Administrator
 * 2015-11-20 11:39:15
 *
 */
public class IntermediateMember implements MemberStrategy {

	@Override
	public double calcPrice(double bookPrice) {
		System.out.println("中级会员打9折！");
		return bookPrice*0.9;
	}

}
