package th.part_21_Concurrence.chapter_04._04CheckInterrupted;

import java.util.concurrent.TimeUnit;

/**
 * 中断发生的唯一时刻：任务将要或已经进入阻塞操作中(I/O synchronized 除外)
 * interrupted()检查当前中断状态
 * @author Administrator
 *
 */
public class NeedClearUp {
	private final int id;

	public NeedClearUp(int id) {
		this.id = id;
		System.out.println("NeedClearUp: " + id);
	}

	public void clearUp() {
		System.out.println("clearUp: " + id);
	}

	static class Blocked3 implements Runnable {
		private volatile double d = 0.0;

		@Override
		public void run() {
			try {
				while (!Thread.interrupted()) {
					NeedClearUp n1 = new NeedClearUp(1);
					try {
						System.out.println("Sleeping ");
						TimeUnit.SECONDS.sleep(1);
						NeedClearUp n2 = new NeedClearUp(2);
						System.out.println("Calculating!");
						try {
							for (int i = 0; i < 2500000; i++)
								d = d + (Math.PI + Math.E) / d;
							System.out.println("Finished time-consuming operation!");
						} catch (Exception e) {
							System.out.println("InterruptedException n2");
						} finally {
							n2.clearUp();
						}
					} catch (InterruptedException e) {
						System.out.println("InterruptedException n1");
					} finally {
						n1.clearUp();
					}
				}
				System.out.println("Exitint while() test! ");
			} catch (Exception e) {
				System.out.println("Exiting Interrupedxception!");
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t=new Thread(new Blocked3());
		t.start();
		TimeUnit.SECONDS.sleep(3);
		t.interrupt();
		System.exit(0);
	}
}
