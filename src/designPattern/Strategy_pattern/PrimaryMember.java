package designPattern.Strategy_pattern;

/**
 * ������Խ�ɫ����װ����ص��㷨����Ϊ
 * ������Ա
 * @author Administrator
 * 2015-11-20 11:37:09
 *
 */
public class PrimaryMember implements MemberStrategy{

	@Override
	public double calcPrice(double bookPrice) {
		System.out.println("������Աû���ۿ�!");
		return bookPrice;
	}
}
