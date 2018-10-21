package th.part_14_TypeInfo.chapter_07_DynamicProxy.dynamicproxy;

public class RealSubject implements Subject {

	@Override
	public void rent() {
		System.out.println("RealSubject:I want to rent my house");
	}

	@Override
	public void cons(String str) {
		System.out.println("RealSubject:"+str);
	}

}
