package th.part_10_InnerClass.chapter_07._02;

/**
 * 多层嵌套类访问外围类成员
 * 
 * @author ken
 * 2016-9-22 下午04:21:05
 */
public class MNA {
	private void f(){
		System.out.println("MNA.f()");
	}
	class A{
		private void g(){
			System.out.println("MNA.A.g()");
		}
		public class B{
			void h(){
				f();
				g();
				System.out.println("MNA.A.B.h()");
			}
		}
	}
}
