package th.part_10_InnerClass.chapter_08._01Closure;


public class CallBack {
	public static void main(String[] args) {
		Callee2 c2=new Callee2();
//		MyIncrement.f(c2);
//		
//		System.out.println("---------------------");
//		Callee1 c1=new Callee1();
//		Caller caller1=new Caller(c1);
//		caller1.go();
		
		System.out.println("---------------------");
		Caller caller2=new Caller(c2.getCallbackReference());
		caller2.go();
		
	}
}
