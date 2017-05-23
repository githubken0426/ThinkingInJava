package th.part_14_TypeInfo.chapter_09._02inner;

import th.part_14_TypeInfo.chapter_09.InteA;

 class InnerA {
	 private static class C implements InteA{

		 	@Override
			public void f() {
				System.out.println("InnerA.C.f()");
			}

			@Override
			public void g() {
				System.out.println("InnerA.C.g()");
			}

			void c(){
				System.out.println("InnerA.C.c()");
			}
			protected void u(){
				System.out.println("InnerA.C.u()");
			}
			
			private void v(){
				System.out.println("InnerA.C.v()");
			}
	 }
	 public static InteA makeA(){
		 return new C();
	 }
}
