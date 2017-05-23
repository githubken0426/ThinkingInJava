package th.part_21_Concurrence.chapter_03._02Synchronized._05Critical;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerMain {
	
/**
 * 获取当前的值 public final int get()
 * 取当前的值，并设置新的值 public final int getAndSet(int newValue)
 * 获取当前的值，并自增 public final int getAndIncrement() 
 * 获取当前的值，并自减 public final int getAndDecrement()
 * 获取当前的值，并加上预期的值public final int getAndAdd(int delta)
 * 
 * @param args
 */
	public static void main(String[] args) {
		AtomicInteger ai = new AtomicInteger(0);
		int i1 = ai.get();
		System.out.println("i1="+i1);
		int i2 = ai.getAndSet(5);
		System.out.println("i2="+i2);
		int i3 = ai.get();
		System.out.println("i3="+i3);
		int i4 = ai.getAndIncrement();
		System.out.println("i4="+i4);
		System.out.println("ai.get()="+ai.get());
	}
}
