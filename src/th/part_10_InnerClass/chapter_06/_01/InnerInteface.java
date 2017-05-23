package th.part_10_InnerClass.chapter_06._01;

public class InnerInteface {
	public interface Service {
		void method1();
		void method2();
	}
	public interface ServiceFactory {
		Service getService();
	}
	
	static class Implementtation1 implements Service{
		//私有构造
		private Implementtation1(){}
		@Override
		public void method1() {
			System.out.println("Implementtation1 method1");
		}

		@Override
		public void method2() {
			System.out.println("Implementtation1 method2");
		}
		
		public static ServiceFactory factory=new ServiceFactory(){
			@Override
			public Service getService() {
				return new Implementtation1();
			}
		};
	}
	
	static class Implementtation2 implements Service{
		//私有构造
		private Implementtation2(){}
		@Override
		public void method1() {
			System.out.println("Implementtation2 method1");
		}

		@Override
		public void method2() {
			System.out.println("Implementtation2 method2");
		}
		
		public static ServiceFactory factory=new ServiceFactory(){
			@Override
			public Service getService() {
				return new Implementtation2();
			}
		};
	}
}
