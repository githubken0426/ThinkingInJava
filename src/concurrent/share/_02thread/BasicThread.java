package concurrent.share._02thread;

import concurrent.share._01runnable.LiftOff;



/**
 *  start����start�����������̣߳�����ʵ���˶��߳����У�
 *  ��ʱ����ȴ�run�ķ����壬���̴߳��ھ����������У�״̬����û�����У�һ���õ�cpuʱ��Ƭ��
 *  �Ϳ�ʼִ��run()���������﷽�� run()��Ϊ�߳��壬��������Ҫִ�е�����̵߳����ݣ�
 *  Run�������н��������߳��漴��ֹ��
 *  
 *  �ܽ᣺����start�������������̣߳�start()���������߳̽��Զ����� run()������������jvm���ڴ���ƹ涨�ġ�
 *  
 *  ʵ�ֽӿںô���
 *  1������̳еľ����ԣ�һ������Լ̳ж���ӿڡ�
����2�������ʺ�����Դ�Ĺ���
 *  
 * 	@author Administrator
 *  2016-1-19 ����09:05:17
 */
public class BasicThread {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new LiftOff());
		t.start();
		new MyThread().start();
		System.out.println(Thread.currentThread()+":Wait for LiftOff");
	}
}


class MyThread extends Thread{
	@Override
	public void run() {
		Thread.currentThread().setName("MyThread");
		System.out.println(Thread.currentThread()+":This is MyThread");
	}
	
}