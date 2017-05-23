package th.part_21_Concurrence.chapter_02._08Daemon;

import java.util.concurrent.TimeUnit;

/**
 * ���Ǻ�̨�߳̽���ʱ����̨�߳�Ҳ�ͽ�����finally�־䲢����ִ��
 * @author Administrator
 *
 */
public class ADaemon implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println("Starting ADaemon");
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			System.out.println("This should always run?");
		}
	}

	/**
	 * finally�־䲢û��ִ��
	 * ����d.setDaemon(false),����main�߳�sleepʱ�䳬����̨�̣߳�finally�־�ͻ�ִ��
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread d=new Thread(new ADaemon());
		d.setDaemon(true);
		d.start();
		TimeUnit.SECONDS.sleep(1);
	}
}
