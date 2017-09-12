package th.part_21_Concurrence.chapter_02._02Thread;

import th.part_21_Concurrence.chapter_02._01Runnable.LiftOff;

/**
 * 无规律输出，有线程调度器自动控制
 * @author Administrator
 * 2016-1-18 上午10:51:00
 *
 */
public class MoreBasicThreads {
	public static void main(String[] args) {
		for(int i=0;i<5;i++)
			new Thread(new LiftOff()).start();
		System.out.println(Thread.currentThread().getName()+":Wait for LiftOff");
	}
}
