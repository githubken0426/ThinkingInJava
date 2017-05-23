package th.part_14_TypeInfo.chapter_09._01hidden;

import th.part_14_TypeInfo.chapter_09.InteA;


public class InterfaceViolation {
	public static void main(String[] args) {
		InteA a=new B();
		a.f();
		a.g();
//		a.c();//compile error
		System.out.println(a.getClass().getCanonicalName());
		if(a instanceof B){
			B b=(B)a;
			b.c("уехЩ",34);
		}
	}
}
