package th.part_21_Concurrence.chapter_02._14Exception;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * UncaughtExceptionHandler��Thread���ڲ���һ���ӿ�
 * @author Administrator
 *
 */
public class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("MyUncaughtExceptionHandler:["+e+"]t.getName():"+t.getName());
	}

}
