package th.part_14_TypeInfo.chapter_02._01;

import java.lang.reflect.Type;

public class GetClassTest {
	
	private static void printInfo(Class<?> c){
		//����ȫ�޶�����
		System.out.println("CalssName:"+c.getName());
		//���ز�������������
		System.out.println("SimpleName:"+c.getSimpleName());
		/**
		 * getName��getCanonicalNam�������������ڴ󲿷�class��˵û��ʲô��ͬ�ģ�
		 * ���Ƕ���array���ڲ���Ⱦ���ʾ������
		 * �����ڸ��������ִ����ļ���ʱ�����ʹ��getCanonicalName()
		 */
		System.out.println("CanonicalName:"+c.getCanonicalName());
	}
	
	public static void main(String[] args) {
		Class<?> c=null;
		/**
		 * forName����������ȫ�޶�����
		 */
		try {
			c=Class.forName("th.part_14_TypeInfo.chapter_02._01.FancyToy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("û���ҵ�");
		}
//		printInfo(c);
		//Class<?>[] getInterfaces()ȷ���˶�������ʾ�����ӿ�ʵ�ֵĽӿ�
		System.out.println("getInterfaces():����ʵ�ֵĽӿڼ��ϡ�������������");
		for(Class<?> cla:c.getInterfaces()){
			printInfo(cla);
		}
		// Type[] getGenericInterfaces()���ر�ʾĳЩ�ӿڵ� Type
		System.out.println("getGenericInterfaces():����ʵ�ֵĽӿڼ��ϡ�������������");
		for(Type cla:c.getGenericInterfaces()){
			System.out.println(cla);
		}
		System.out.println("������������������������������������������");
		Class<?> up=c.getSuperclass();//���ػ���
		Object obj=null;
		try {
			/**
			 * ע�͵�Toy���޲ι��죬java.lang.InstantiationException�쳣
			 * newInstance(): ������,��Ч��,ֻ�ܵ����޲ι���
			 */
			obj=up.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		printInfo(obj.getClass());
//		System.out.println(obj.getClass());
	}
}
