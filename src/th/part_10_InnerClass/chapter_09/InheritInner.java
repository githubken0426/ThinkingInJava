package th.part_10_InnerClass.chapter_09;
/**
 * 10.9
 * 内部类的继承
 * 
 * @author ken
 * 2016-9-23 下午02:04:01
 */
public class InheritInner extends WithInner.Innser{
	//compile error InheritInner(){}
	/**
	 * 继承内部类的构造函数
	 * 必须使用外围类的引用--》
	 * enclosingClassReference.super();
	 */
	InheritInner(WithInner withIn){
		withIn.super();//指向内部类构造
	}
	
	public static void main(String[] args) {
		WithInner with=new WithInner("test");
		InheritInner in=new InheritInner(with);
	}
}
