package th.part_14_TypeInfo.chapter_09._03anonymous;

import th.part_14_TypeInfo.chapter_09.InteA;

public class AnonymousA {
	public static InteA makeA(){
		return new InteA(){
			@Override
			public void f() {
				System.out.println("AnonymousA.f()");
			}

			@Override
			public void g() {
				System.out.println("AnonymousA.c()");
			}
			
			void c(){
				System.out.println("AnonymousA.c()");
			}
			protected void u(){
				System.out.println("AnonymousA.u()");
			}
			
			private void v(){
				System.out.println("AnonymousA.v()");
			}
		};
	}
}
