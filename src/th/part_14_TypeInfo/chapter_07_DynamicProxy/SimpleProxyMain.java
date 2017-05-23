package th.part_14_TypeInfo.chapter_07_DynamicProxy;

/**
 * 代理
 * @author Administrator
 * 2015年9月14日
 */
public class SimpleProxyMain {
	public static void consumer(InterfaceProxy proxied){
		proxied.doSomething();
		proxied.somethingElse(" bonobo");
	}
	
	public static void main(String[] args) {
//		consumer(new RealObject());
//		System.out.println("=======================");
		consumer(new SimpleProxy(new RealObject()));
	}
}
