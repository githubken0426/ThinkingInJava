package concurrent.share._04executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import th.part_21_Concurrence.chapter_02._01Runnable.LiftOff;

/**
 * newFixedThreadPoolָ���߳�����
 * �������̳߳��У������߳��п��ܵ�����£����ᱻ����
 * @author Administrator
 * 2016-1-18 ����04:04:48
 *
 */
public class FixedThreadPool {
	public static void main(String[] args) {
		ExecutorService exe=Executors.newFixedThreadPool(3);
		for(int i =0;i<5;i++){
			exe.execute(new LiftOff());
		}
		exe.shutdown();
	}
}
