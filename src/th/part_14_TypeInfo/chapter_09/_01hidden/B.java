package th.part_14_TypeInfo.chapter_09._01hidden;

import th.part_14_TypeInfo.chapter_09.InteA;

public class B implements InteA {

	@Override
	public void f() {
		System.out.println("public void f()");
	}

	@Override
	public void g() {
		System.out.println("public void g()");
	}
	
	public void c(String name,int age){
		System.out.println("private void c(String name,int age),ĞÕÃû:"+name+",ÄêÁä:"+age);
	}
	
	public static class B_Class {
		public static B getB(){
			return new B(){
				public void b_f(){
					System.out.println("public void b_f()");
				}
				private void b_c(){
					System.out.println("private void B_Class.b_c()");
				}
			};
		}
	}
}
