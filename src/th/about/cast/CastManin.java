package th.about.cast;


public class CastManin {

	public static void main(String[] args) {
		Object obj=-1;
		castStatic(null);
		dynamicKnow(obj);
		int a=1;
		Student stu=new Student();
		dynamicUnknow(stu);
		
	}
	
	/**
	 * 静态转型
	 */
	public static void castStatic(Object obj){
		System.out.println("我是静态转型例子:");
		//null可以被任何对象引用
		if(obj instanceof Integer){
			Integer objInt=(Integer) obj;
			System.out.println("转型成功:"+objInt);
		}
	}
	/**
	 * 动态转已知类型
	 * 转成的类型，也是在编译期就知道的，没必要这么做
	 */
	public static void dynamicKnow(Object obj){
		System.out.println("我是动态转已知类型例子:");
		if(Integer.class.isInstance(obj)){
			Integer objInt=Integer.class.cast(obj);
			System.out.println("转型成功:"+objInt);
		}
	}
	/**
	 * 动态转未知类型
	 */
	public static void dynamicUnknow(Object obj){
		System.out.println("我是动态转未知类型例子:");
		Class<Student> type=null;
		if(type.isInstance(obj)){
			Student stu=type.cast(obj);
		}
		
	}
}
