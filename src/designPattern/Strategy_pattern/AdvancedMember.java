package designPattern.Strategy_pattern;

/**
 * ������Խ�ɫ����װ����ص��㷨����Ϊ
 * �߼���Ա
 * @author Administrator
 * 2015-11-20 11:40:36
 *
 */
public class AdvancedMember implements MemberStrategy{
	@Override  
	public double calcPrice(double bookPrice) {
		System.out.println("�߼���Ա����8���Żݣ�");
		return bookPrice*0.8;
	}
}
