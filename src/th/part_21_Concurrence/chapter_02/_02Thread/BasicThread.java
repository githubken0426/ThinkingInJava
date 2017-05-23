package th.part_21_Concurrence.chapter_02._02Thread;

import th.part_21_Concurrence.chapter_02._01Runnable.LiftOff;


/**
 *  1�� start����start�����������̣߳�����ʵ���˶��߳����У�
 *  ��ʱ����ȴ�run������,����ִ����϶�ֱ�Ӽ���ִ������Ĵ��롣
 *  ��ʱ���̴߳��ھ����������У�״̬����û�����У�һ���õ�cpuʱ��Ƭ��
 *  �Ϳ�ʼִ��run()���������﷽�� run()��Ϊ�߳��壬��������Ҫִ�е�����̵߳����ݣ�
 *  Run�������н��������߳��漴��ֹ��
 *  
 *  2�� run��run()����ֻ�����һ����ͨ�������ѣ����ֱ�ӵ���Run������
 *  ��������Ȼֻ�����߳���һ���̣߳������ִ��·������ֻ��һ��������Ҫ˳��ִ�У�
 *  ����Ҫ�ȴ�run������ִ����Ϻ�ſɼ���ִ������Ĵ��룬������û�дﵽд�̵߳�Ŀ�ġ�
 *  
 *  �ܽ᣺����start�������������̣߳���run����ֻ��thread��һ����ͨ�������ã����������߳���ִ�С�
 *  start()���������߳̽��Զ����� run()������������jvm���ڴ���ƹ涨�ġ�
 *  ����run()����������public����Ȩ�ޣ�����ֵ����Ϊvoid.
 * 	@author Administrator
 *  2016-1-19 ����09:05:17
 */
public class BasicThread {
	public static void main(String[] args) throws InterruptedException {
		Thread t=new Thread(new LiftOff());
		t.start();
		/**
		 * �˴��������"Wait for LiftOff"
		 * ��ʵ���������߳�������:main�̺߳�Thread-0�߳�
		 * ��ͬʱִ��LiftOff.run()��main()��������
		 *
		 */
		System.out.println("Wait for LiftOff");
	}
}
