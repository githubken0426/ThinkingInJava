package th.part_21_Concurrence.chapter_02._03Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import th.part_21_Concurrence.chapter_02._01Runnable.LiftOff;
/**
 * newSingleThreadExecutor()����newFixedThreadPool(1)
 * �����newSingleThreadExecutor()�ύ������񣬶�����񽫻��Ŷӣ�ÿ�����񽫻�����һ������ʼ֮ǰ����
 * �о��е�����ֱ�ӵ���run()����
 * �������̳߳��У������߳��п��ܵ�����£����ᱻ����
 * @author Administrator
 * 2016-1-18 ����04:17:42
 *
 */
public class SingleThreadPool {
	public static void main(String[] args) {
		ExecutorService exe=Executors.newSingleThreadExecutor();
		for(int i =0;i<2;i++){
			exe.execute(new LiftOff());
		}
		exe.shutdown();
	}
}
