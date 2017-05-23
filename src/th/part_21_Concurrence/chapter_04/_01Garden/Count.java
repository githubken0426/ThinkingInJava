package th.part_21_Concurrence.chapter_04._01Garden;

import java.util.Random;

public class Count {
	private int count=0;
	private Random random=new Random(47);
	
	public synchronized int incrment(){
		int temp=count;//变量及返回值仅仅是为了增加计算过程及加大了程序失败的可能性
		if(random.nextBoolean())//为了让线程更多的产生让步
			Thread.yield();
		return (count=++temp);
	}
	
	public synchronized int value(){
		return count;
	}
	
}
