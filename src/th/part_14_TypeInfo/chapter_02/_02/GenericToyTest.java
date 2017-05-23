package th.part_14_TypeInfo.chapter_02._02;

import th.part_14_TypeInfo.chapter_02._01.FancyToy;

public class GenericToyTest {
	public static void main(String[] args) throws Exception {
		Class<FancyToy> ftClass=FancyToy.class;
		System.out.println(ftClass);
		/**
		 * 获取实例之后才能获取对象属性
		 */
		FancyToy fancy=ftClass.newInstance();
		System.out.println(fancy.getId());
		/**
		 * ? super FancyToy 
		 * 虽然FancyToy继承Toy，但是compile不接受这样的声明
		 * getSuperclass()返回的基类类型
		 */
		Class<? super FancyToy> up=ftClass.getSuperclass();
		System.out.println(up);
		Object obj= up.newInstance();
		System.out.println("obj:"+obj);
		/**
		 * 运行报错。不能转换
		 */
		//FancyToy o=(FancyToy) up.newInstance();
	}
}
