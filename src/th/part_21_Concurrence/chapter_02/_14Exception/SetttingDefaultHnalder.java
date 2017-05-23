package th.part_21_Concurrence.chapter_02._14Exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Thread.setDefaultUncaughtExceptionHandler()
 * ϵͳ���ȼ���߳��Ƿ���ר�е�uncaughtException()������
 * ���û�о��ڵ���defaultUncaughtExceptionHandler
 * @author Administrator
 * 2016-4-29 ����10:26:17
 *
 */
public class SetttingDefaultHnalder {
	public static void main(String[] args) {
		Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("������쳣��"+e);
			}
		});
		ExecutorService exe=Executors.newCachedThreadPool();
		exe.execute(new ExceptionThread());
		exe.shutdown();
	}
}
