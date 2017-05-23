package th.part_10_InnerClass.chapter_06;

/**
 * 实例初始化达到匿名构造器效果
 * 
 * @author ken
 * 2016-9-20 下午03:29:19
 */
public class ParcelBase {
	abstract class Base{
		public Base(int i){
			System.out.println("Base constructor "+i);
		}
		public abstract void f();
	}
	
	public static class AnonymousConstructor{
		/**
		 * i不需要final，因为i是传递给匿名类基类的构造器使用
		 * 匿名类并不直接使用
		 * @param i
		 * @return
		 * 2016-9-21 上午10:32:36
		 */
		public  Base getBase(int i){
			return new ParcelBase().new Base(i){
				{System.out.println("Inside Instance Initializer");}
				@Override
				public void f() {
					System.out.println("In anonymous f()");
				}
			};
		}
	}
	public static void main(String[] args) {
		Base base=new AnonymousConstructor().getBase(47);
		base.f();
		
	}
}
