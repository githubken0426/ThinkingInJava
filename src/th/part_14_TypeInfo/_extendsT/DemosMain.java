package th.part_14_TypeInfo._extendsT;

import java.util.*;

public class DemosMain {
	/**
	 * �����ǲ�֪����������;�����ʲô����Ϊû��ȷ����
	 * Ϊ�˱�֤���Ͱ�ȫ�����ǾͲ���������������κ��������͵�����
	 * @param args
	 */
	public static void main(String[] args) {
		List<? extends Fruit> fruit=new ArrayList<Fruit>();
//		fruit.add(new Fruit());
//		fruit.add(new Apple());
//		fruit.add(new RedApple());
		fruit.add(null);
		
		List<Apple> apples = new ArrayList<Apple>();
		//����ͨ��
		List<? extends Fruit> app=apples;
		//����add,����ͨ���������ע��ֵ
		//app.add(new RedApple());
		List<Class<? extends Fruit>> reflact=Collections.unmodifiableList(
				Arrays.asList(Fruit.class,Apple.class,RedApple.class));
	}
}
