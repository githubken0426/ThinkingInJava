package th.part_21_Concurrence.chapter_02._03Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import th.part_21_Concurrence.chapter_02._01Runnable.LiftOff;

/**
 * newCachedThreadPool()����Ϊÿ�����񴴽��߳�
 * ��ͨ���ᴴ������Ҫ���߳��������վ��߳�ʱ��ֹͣ�������߳�
 * �������Executor����ѡ
 * �������̳߳��У������߳��п��ܵ�����£����ᱻ����
 * @author Administrator
 * 2016-1-18 ����04:21:37
 *
 */
public class CashedThreadPool {
	public static void main(String[] args) {
		ExecutorService exe=Executors.newCachedThreadPool();
		for(int i =0;i<3;i++){
			exe.execute(new LiftOff());
		}
		//һ��Ҫ�ر�,����Executors�̻߳�һֱ����
		exe.shutdown();
	}
}
