package th.part_14_TypeInfo.chapter_07_DynamicProxy;

/**
 * 簡單代理
 * @author ken
 *
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
