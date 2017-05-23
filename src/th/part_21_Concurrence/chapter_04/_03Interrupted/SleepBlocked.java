package th.part_21_Concurrence.chapter_04._03Interrupted;

import java.util.concurrent.TimeUnit;

public class SleepBlocked implements Runnable {

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(100);
		} catch (InterruptedException e) {
			System.out.println("InterruptedException SleepBlockedÖÐ¶Ïcatch¿ì!");
		}
		System.out.println("Exting SleepBlocked.run() ");
	}
	

}
