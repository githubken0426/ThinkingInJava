package th.part_10_InnerClass.chapter_07._02;

/**
 * ���Ƕ���������Χ���Ա
 * 
 * @author ken
 * 2016-9-22 ����04:21:05
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
