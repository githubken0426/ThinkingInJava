package designPattern.Strategy_pattern;

/**
 * ������Խ�ɫ����װ����ص��㷨����Ϊ
 * �м���Ա
 * @author Administrator
 * 2015-11-20 11:39:15
 *
 */
public class IntermediateMember implements MemberStrategy {

	@Override
	public double calcPrice(double bookPrice) {
		System.out.println("�м���Ա��9�ۣ�");
		return bookPrice*0.9;
	}

}
