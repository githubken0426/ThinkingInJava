package th.part_21_Concurrence.chapter_04._03Interrupted;


public class SynchronizedBlocked implements Runnable {

	/**
	 * �����ж����ڻ�ȡ������ͼ����IO���߳�
	 */
	public synchronized void f() {
		while (true) {
			Thread.yield();// ���ͷ���������
		}
	}

	public SynchronizedBlocked() {
		new Thread() {
			public void run() {
				f();
			}
		}.start();
	}

	@Override
	public void run() {
		System.out.println("Trying to call f()");
		f();
		/**
		 * f()������������ò���ִ��
		 */
		System.out.println("Exiting SynchronizedBlocked.run()");

	}

}
