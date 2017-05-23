package th.part_14_TypeInfo.chapter_07_DynamicProxy.filterMethod;

public class ImplementMethod implements SomeMethods {

	@Override
	public void boring1() {
		System.out.println("This is boring1");
	}

	@Override
	public void boring2() {
		System.out.println("This is boring2");
	}

	@Override
	public void insteresting(String str) {
		System.out.println("This is insteresting "+str);
	}

	@Override
	public void test() {
		System.out.println("This is test");
	}

}
