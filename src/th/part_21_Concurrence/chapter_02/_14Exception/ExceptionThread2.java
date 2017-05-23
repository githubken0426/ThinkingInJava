package th.part_21_Concurrence.chapter_02._14Exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ExceptionThread2 implements Runnable{

	@Override
	public void run() {
		System.out.println("**run() by "+Thread.currentThread());
		System.out.println("**run() en:"+Thread.currentThread().getUncaughtExceptionHandler());
		/**
		 * �ڲ����ʵ�֣�
		 * �׳��쳣����Ҫ��HandlerThreadFactory��setUncaughtExceptionHandler()�����в�����쳣��
		 * ���Ի���ִ��HandlerThreadFactory�е�run()��
		 * 
		 * other����������
		 */
		throw new RuntimeException();
	}
	

public static void main(String[] args) {
		ExecutorService exe=Executors.newCachedThreadPool(new HandlerThreadFactory());
		exe.execute(new ExceptionThread2());
		exe.shutdown();
	}
}
