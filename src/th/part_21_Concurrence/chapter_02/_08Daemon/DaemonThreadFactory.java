package th.part_21_Concurrence.chapter_02._08Daemon;

import java.util.concurrent.ThreadFactory;

/**
 * ��̨�̹߳�����
 * Ҳ���Դ������ȼ����߳����Ƶ����ԵĹ�����
 * @author Administrator
 * 2016-1-19 ����04:38:04
 *
 */
public class DaemonThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r) {
		Thread t=new Thread(r);
		t.setDaemon(true);
		return t;
	}

}
