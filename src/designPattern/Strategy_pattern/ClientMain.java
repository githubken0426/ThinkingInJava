package designPattern.Strategy_pattern;

public class ClientMain {
	/**
	 * ����ģʽӦ�ó�����
	 * 1�� �����ֻ�����ڱ�����Ϊ��ͬ������ʹ��Strategyģʽ��������ʱ��̬ѡ�����Ҫִ�е���Ϊ��
	 * 2�� ��Ҫ�ڲ�ͬ�����ʹ�ò�ͬ�Ĳ���(�㷨)�����߲��Ի�������δ����������ʽ��ʵ�֡�
	 * 3�� �Կͻ����ؾ������(�㷨)��ʵ��ϸ�ڣ��˴���ȫ������
	 * @param args
	 */
	public static void main(String[] args) {
		MemberStrategy strategy=new PrimaryMember();
		Price price=new Price(strategy);
		System.out.println(price.quote(100));
		
		Price p=new Price(new MemberStrategy(){//Ҳ���Դ���PrimaryMember���󣬵��Ƿ������Բ�����д
			@Override
			public double calcPrice(double bookPrice) {
				System.out.println("���Ǽ۸�:"+bookPrice);
				return bookPrice;
			}
		});
		System.out.println(p.quote(100));
	}
}
