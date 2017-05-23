package th.part_10_InnerClass.chapter_06._01;

import th.part_10_InnerClass.chapter_06._01.InnerInteface.Implementtation1;
import th.part_10_InnerClass.chapter_06._01.InnerInteface.Implementtation2;
import th.part_10_InnerClass.chapter_06._01.InnerInteface.Service;
import th.part_10_InnerClass.chapter_06._01.InnerInteface.ServiceFactory;

public class Factories {
	
	public static void ServiceConsumer(ServiceFactory factory){
		Service service=factory.getService();
		service.method1();
		service.method2();
	}
	
	public static void main(String[] args) {
		ServiceConsumer(Implementtation1.factory);
		System.out.println("*****************************");
		ServiceConsumer(Implementtation2.factory);
	}
}
