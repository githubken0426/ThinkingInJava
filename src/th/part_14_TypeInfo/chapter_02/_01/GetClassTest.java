package th.part_14_TypeInfo.chapter_02._01;

import java.lang.reflect.Type;

public class GetClassTest {
	
	private static void printInfo(Class<?> c){
		//返回全限定类名
		System.out.println("CalssName:"+c.getName());
		//返回不包含包的类名
		System.out.println("SimpleName:"+c.getSimpleName());
		/**
		 * getName、getCanonicalNam这两个方法对于大部分class来说没有什么不同的，
		 * 但是对于array或内部类等就显示出来了
		 * 另外在根据类名字创建文件的时候最好使用getCanonicalName()
		 */
		System.out.println("CanonicalName:"+c.getCanonicalName());
	}
	
	public static void main(String[] args) {
		Class<?> c=null;
		/**
		 * forName参数必须是全限定类名
		 */
		try {
			c=Class.forName("th.part_14_TypeInfo.chapter_02._01.FancyToy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("没有找到");
		}
//		printInfo(c);
		//Class<?>[] getInterfaces()确定此对象所表示的类或接口实现的接口
		System.out.println("getInterfaces():返回实现的接口集合———————");
		for(Class<?> cla:c.getInterfaces()){
			printInfo(cla);
		}
		// Type[] getGenericInterfaces()返回表示某些接口的 Type
		System.out.println("getGenericInterfaces():返回实现的接口集合———————");
		for(Type cla:c.getGenericInterfaces()){
			System.out.println(cla);
		}
		System.out.println("—————————————————————");
		Class<?> up=c.getSuperclass();//返回基类
		Object obj=null;
		try {
			/**
			 * 注释掉Toy的无参构造，java.lang.InstantiationException异常
			 * newInstance(): 弱类型,低效率,只能调用无参构造
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
