package th.part_10_InnerClass.chapter_07._02;

public class MutiNestingAccess {
	public static void main(String[] args) {
		MNA man=new MNA();
		MNA.A a=man.new A();
		MNA.A.B b=a.new B();
		b.h();
	}
}
