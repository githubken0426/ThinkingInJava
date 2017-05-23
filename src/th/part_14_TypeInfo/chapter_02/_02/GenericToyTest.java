package th.part_14_TypeInfo.chapter_02._02;

import th.part_14_TypeInfo.chapter_02._01.FancyToy;

public class GenericToyTest {
	public static void main(String[] args) throws Exception {
		Class<FancyToy> ftClass=FancyToy.class;
		System.out.println(ftClass);
		/**
		 * ��ȡʵ��֮����ܻ�ȡ��������
		 */
		FancyToy fancy=ftClass.newInstance();
		System.out.println(fancy.getId());
		/**
		 * ? super FancyToy 
		 * ��ȻFancyToy�̳�Toy������compile����������������
		 * getSuperclass()���صĻ�������
		 */
		Class<? super FancyToy> up=ftClass.getSuperclass();
		System.out.println(up);
		Object obj= up.newInstance();
		System.out.println("obj:"+obj);
		/**
		 * ���б�������ת��
		 */
		//FancyToy o=(FancyToy) up.newInstance();
	}
}
