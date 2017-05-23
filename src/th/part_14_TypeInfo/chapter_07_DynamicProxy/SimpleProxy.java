package th.part_14_TypeInfo.chapter_07_DynamicProxy;

public class SimpleProxy implements InterfaceProxy {
	private InterfaceProxy proxied;
	
	public SimpleProxy(InterfaceProxy proxied){
		this.proxied=proxied;
	}

	@Override
	public void doSomething() {
//		System.out.println("SimpleProxy doSomething..");
		proxied.doSomething();
	}

	@Override
	public void somethingElse(String str) {
//		System.out.println("SimpleProxy somethingElse:"+str);
		proxied.somethingElse(str);
	}
}
