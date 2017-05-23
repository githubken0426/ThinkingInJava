package th.part_14_TypeInfo.chapter_07_DynamicProxy;
/**
 * 14.7 简单代理
 * @author Administrator
 * 2015年9月11日
 */
public class SimpleProxyTest {
	//目标类的统一的接口
	public interface InterfaceProxy {
		void doSomething();
		void somethingElse(String str);
	}
	//简单的接口实现
	public class RealObject implements InterfaceProxy {
		@Override public void doSomething() {
			System.out.println("doSomething...");
		}
		@Override public void somethingElse(String str) {
			System.out.println("somethingElse:"+str);
		}
	}
	//代理接口实现
	public class SimpleProxy implements InterfaceProxy {
		private InterfaceProxy proxied;
		public SimpleProxy(InterfaceProxy proxied){
			this.proxied=proxied;
		}
		@Override public void doSomething() {
			proxied.doSomething();
		}
		@Override public void somethingElse(String str) {
			proxied.somethingElse(str);
		}
	}
	
	public static void consumer(InterfaceProxy proxied){
		proxied.doSomething();
		proxied.somethingElse(" bonobo");
	}
	
	/**
	 * 因为consumer()方法接收InterfaceProxy接口，
	 * simpleProxy和RealObject()均实现了InterfaceProxy接口，所以会执行此操作。
	 * @param args
	 * 2016-12-6 上午11:29:32
	 */
	public static void main(String[] args) {
		SimpleProxyTest test=new SimpleProxyTest();
		consumer(test.new RealObject());
		System.out.println("=======================");
		consumer(test.new SimpleProxy(test.new RealObject()));
	}
	
}
