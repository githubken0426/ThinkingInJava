package th.part_10_InnerClass.chapter_08;
/**
 * 10.8 为何需要内部类
 * 内部类和外围类实现接口最终效果是一样的。
 * 内部类更加方便高效，内部类的内部封装更加安全
 * 内部类拥有一个指向外围类的引用，它还包含外围类的信息，内部类也可以操作外围类私有成员
 * 
 * @author ken
 * 2016-9-22 下午05:07:56
 */
public class WhyNeedInnerClass {
	interface A{}
	interface B{}
	
	class X implements A,B{}
	
	class Y implements A{
		B makeB(){
			return new B(){};
		}
	}
	
}
