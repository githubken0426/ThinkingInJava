package th.part_21_Concurrence.chapter_03._02Synchronized._06CriticalOther;

public class DualSych {
	
	private Object syncObject = new Object();
	/**
	 * f()类似synchronized(this) 此处的this是DualSych
	 */
	public synchronized void f() {
		System.out.println("f():"+Thread.currentThread());
		for (int i = 0; i < 5; i++) {
			System.out.println("f()");
			Thread.yield();
		}
	}

	/**
	 * g()方法是在syncObject上同步的
	 */
	public void g() {
		synchronized (syncObject) {
			System.out.println("g():"+Thread.currentThread());
			for (int i = 0; i < 5; i++) {
				System.out.println("g()");
				Thread.yield();
			}
		}
	}

	/**
	 * f()和g()两个同步是互相独立的，他们是在不同的对象上同步
	 * 他们都可以进入同一个对象：main线程
	 * 输出可以看出两个方法同是运行，没有产生阻塞
	 * 在同一个对象上同步，同步快中只能有一个任务，其他任务会阻塞，直到当前任务结束
	 * @param args
	 */
	public static void main(String[] args) {
		final DualSych ds = new DualSych();
		new Thread("F") {
			public void run() {
				ds.f();
			}
		}.start();
		System.out.println("____________________________");
		ds.g();
	}
}
