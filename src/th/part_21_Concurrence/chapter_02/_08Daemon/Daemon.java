package th.part_21_Concurrence.chapter_02._08Daemon;

import java.util.concurrent.TimeUnit;

public class Daemon implements Runnable {
	private static int id=1;
	private Thread [] t=new Thread[10];
	
	/**
	 * ��Ȼrun()����������ѭ������Ϊ�Ǻ�̨�̣߳��Ǻ�̨�߳̽���ʱ��Ҳ��ɱ���˺�̨�̣߳���ѭ������
	 */
	@Override
	public void run() {
		for(int i=0;i<t.length;i++){
			t[i]=new Thread(new DaemonSpawn());
			t[i].start();
			System.out.println("DeamonSpawn_"+i+":Started!");
		}
		try {
			/*
			 * ��main�̵߳�sleepʱ��С�ں�̨�̵߳�sleepʱ��ʱ��
			 * Ҳ����main�߳�����ʱ��ͻ�ɱ����̨�̣߳��˺�������п��ܲ��ᱻִ��
			 */
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int z=0;z<t.length;z++)
			System.out.println(t[z].getName()+ ",t["+z+"].isDaemon():"+t[z].isDaemon()+",");
		while(true)
			Thread.yield();
	}

	public class DaemonSpawn implements Runnable {
		@Override
		public void run() {
			System.out.println("test"+id++);
			while(true){
				Thread.yield();
			}
		}
	}

	/**
	 * ע�͵�d.setDaemon(true)������ͻ������ѭ��
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread d=new Thread(new Daemon());
		d.setDaemon(true);
		d.start();
		System.out.println("d.isDaemon():"+d.isDaemon()+",��Ҫ��˯����");
		TimeUnit.SECONDS.sleep(3);
		System.out.println("end!");
	}
}
