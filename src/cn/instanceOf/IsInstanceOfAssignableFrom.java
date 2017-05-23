package cn.instanceOf;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * instanceof isInstance() isAssignableFrom()�����Ա�
 * 
 * 1:instanceof ���ʵ�� �ʺ�ֱ�����͵ļ�飬������ͨ��Class�������
 * 2:Class1.isAssignableFrom(Class2<?> cls)�� �ж�Class1��Class2�Ƿ���ͬ
 * ���ж�Class1���Ƿ���Class2�ĳ����ӿ� 
 * �����ߺͲ�������java.lang.Class����
 * 3:Class.isInstance(Object obj) obj�Ǳ����ԵĶ������obj�ǵ������������class��ӿڵ�ʵ�����򷵻�true
 * �ʺϷ����͵ļ�⣨������ӿڣ�������ȹ��򣩣����뷺��Class�������
 * @author ken 
 * 2016-3-25 ����04:13:48
 */
public class IsInstanceOfAssignableFrom {
	public static void main(String[] args) {
		String str = "str";
		System.out.println("instanceof:" + (str instanceof String));
		/**
		 * ͨ��ģ��Դ�뿴����������������xxx.class
		 * Դ������xxx.class.getClass()����
		 * ���շ���class java.lang.Class
		 * ��������Ҫ���ص��Ǹ�xxx����
		 * ���Դ�����������ʵ����������class����
		 */
		Class<? extends Object> s =String.class.getClass();
		System.out.println(s);//��� class java.lang.Class
		System.out.println("isInstance()1:"+str.getClass().isInstance(String.class));	//���false
		System.out.println("isInstance()2:"+String.class.isInstance(str.getClass()));	//ͬ�ϣ����false
		System.out.println("isInstance()3:"+String.class.isInstance(str));				//���true
		System.out.println("�Զ���isInstance():"+ IsInstanceOfAssignableFrom.isInstance(str,String.class));//���true
		/**
		 * �˴�name���ص�ΪString����(��getSimpleName()���������޹�), Ҳ����name����ΪString����
		 * ��bn2Ч����ͬ
		 */
		String name = str.getClass().getSimpleName();
		System.out.println("\nbn:" + String.class.isInstance(name));
		System.out.println("bn2:" + String.class.isInstance(str));
		// Object��������ĳ���
		System.out.println("\nisAssginableFrom():"+ Object.class.isAssignableFrom(ArrayList.class));//���true
		System.out.println("isAssginableFrom():"+ ArrayList.class.isAssignableFrom(Object.class));  //���false
	}
	
	/**
	 * ģ��isInstance()Դ��ʵ��
	 * @param obj ģ�⴫��Ĳ���
	 * @param cls ģ��class����
	 * @return
	 * 2016-12-13 ����10:09:35
	 */
	public static boolean isInstance(Object obj,Class<?> cls) {
		if (obj == null) {
			return false;
		}
		Class<? extends Object> cl= obj.getClass();
		if (cl == cls) {// ��鵱ǰ���ʵ��
			return true;
		}
		if (Arrays.asList(obj.getClass().getInterfaces()).contains(cls)) {// ���ӿڵ�ʵ��
			return true;
		}
		/**
		 * �����ѯ�õ��Ļ����� true;
		 * ������java.lang.Object.class����ֹ,������Ҫע�⣬
		 * a.getClass().getInterfaces()�ǻ�ȡ�������еĽӿڣ����Խ����������ӿ������
		 */
		Class<? extends Object> superClass = obj.getClass().getSuperclass();
		while (superClass != Object.class) {
			if (superClass == cls) {
				return true;
			}
			superClass = superClass.getClass();
		}
		return false;
	}
}
