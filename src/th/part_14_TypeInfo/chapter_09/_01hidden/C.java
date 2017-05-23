package th.part_14_TypeInfo.chapter_09._01hidden;

import th.part_14_TypeInfo.chapter_09.InteA;

 class C implements InteA {

	@Override
	public void f() {
		System.out.println("C.f()");
	}

	@Override
	public void g() {
		System.out.println("C.g()");
	}

	void c(){
		System.out.println("C.c()");
	}
	protected void u(){
		System.out.println("C.u()");
	}
	
	private void v(){
		System.out.println("C.v()");
	}
}
