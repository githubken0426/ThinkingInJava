package cn.cglib.lazyload;

public class LazyMain {
	public static void main(String[] args) {
		//���۵��ö�����ԣ�LazyBeanֻ����һ��
		LazyBean bean = new LazyBean("lisi", 23);
		PropertyBean property=bean.getPropertyBean();
		System.out.println("���ε��ã�"+property.getKey());
		System.out.println(property.getValue());
		System.out.println("�ٴε��ã�"+property.getKey());
		
		System.out.println("-----------------------------------------");
		//���ö��ٴ����ԣ�LazyBean���ض��ٴ�
		PropertyBean dispatcher=bean.getPropertyBeanDispatcher();
		System.out.println("���ε��ã�"+dispatcher.getKey());
		System.out.println(property.getValue());
		System.out.println("�ٴε��ã�"+dispatcher.getKey());
	}
}
