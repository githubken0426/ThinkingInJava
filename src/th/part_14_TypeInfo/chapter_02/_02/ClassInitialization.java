package th.part_14_TypeInfo.chapter_02._02;

import java.util.Random;

public class ClassInitialization {
	public static Random rand = new Random(47);
	/**
	 * 如果一个static final值是编译期常量，那么对该值的引用无需对其所在类进行初始化;
	 * 若仅仅是static和final但不是编译期常量，则会引发初始化其类。 
	 * 若是引用一个static值则要进行链接并对其所在类进行初始化。
	 * 
	 * 行初始化类并不调用构造函数，证明构造函数不是隐形静态方法
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 不会引起初始化
		Class initable = Initable.class;
		System.out.println("***** after creating Initable reference *********");
		// 引用编译器常量不会引起初始化
		System.out.println("Initable.staticFinal是编译器常量:" + Initable.staticFinal); 
		
		// 引用非编译期常量会引起初始化，但是构造函数还是不执行
		System.out.println(Initable.staticFinal2);
		System.out.println("Initable2.staticNoFinal也是编译器常量:"+Initable2.staticNoFinal);
		try {
			// forName会引起初始化
			Class initable3 = Class.forName("th.part_14_TypeInfo.chapter_02._02.Initable3");
			//调用无参构造器
			initable3.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		// System. out .println(
		// "***** after creating Initable3 reference *****" );
		// // 前面已经初始化此处不用再初始化
		// System. out .println(Initable3.staticNoFinal);

		/**
		 * 测试类型
		 */
		System.out.println("void.class:" + void.class);
		System.out.println("Void.TYPE:" + Void.TYPE);
		System.out.println((void.class).equals(Void.TYPE));
		System.out.println(void.class==Void.TYPE);
	}
}
