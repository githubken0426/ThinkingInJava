package designPattern.Strategy_pattern;

/**
 * ������Խ�ɫ�� �����࣬ͨ����һ���ӿڻ��߳�����ʵ�֡�
 * ��Ա����
 * �㷨һ���Գ�����Աû���ۿۡ�
 * �㷨�������м���Ա�ṩ10%�Ĵ����ۿۡ�
 * �㷨�����Ը߼���Ա�ṩ20%�Ĵ����ۿۡ�
 * @author Administrator
 * 2015-11-20 ����11:33:14
 *
 */

public interface MemberStrategy {
	/**
	 * ����:����۸�
	 * @param bookPrice ԭ��
	 * @return �ۺ��
	 */
	public double calcPrice(double bookPrice);
	
}
