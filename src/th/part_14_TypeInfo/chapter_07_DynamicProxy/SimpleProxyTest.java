package th.part_14_TypeInfo.chapter_07_DynamicProxy;
/**
 * 14.7 简单代理
 * @author Administrator
 * 2015-9-11:上午
 */
public class SimpleProxyTest {
	//Ŀ�����ͳһ�Ľӿ�
	public interface InterfaceProxy {
		void doSomething();
		void somethingElse(String str);
	}
	//�򵥵Ľӿ�ʵ��
	public class RealObject implements InterfaceProxy {
		@Override public void doSomething() {
			System.out.println("doSomething...");
		}
		@Override public void somethingElse(String str) {
			System.out.println("somethingElse:"+str);
		}
	}
	//����ӿ�ʵ��
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
	 * ��Ϊconsumer()��������InterfaceProxy�ӿڣ�
	 * simpleProxy��RealObject()��ʵ����InterfaceProxy�ӿڣ����Ի�ִ�д˲�����
	 * @param args
	 * 2016-12-6 ����11:29:32
	 */
	public static void main(String[] args) {
		SimpleProxyTest test=new SimpleProxyTest();
		consumer(test.new RealObject());
		System.out.println("=======================");
		consumer(test.new SimpleProxy(test.new RealObject()));
	}
	
}
