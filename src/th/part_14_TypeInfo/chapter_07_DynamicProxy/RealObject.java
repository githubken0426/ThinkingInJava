package th.part_14_TypeInfo.chapter_07_DynamicProxy;


public class RealObject implements InterfaceProxy {

	@Override
	public void doSomething() {
		System.out.println("RealObject doSomething...");
	}

	@Override
	public void somethingElse(String str) {
		System.out.println("RealObject somethingElse:"+str);
	}

}
