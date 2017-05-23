package th.part_21_Concurrence.chapter_05._01;

import java.util.concurrent.TimeUnit;

public class WaxOff implements Runnable {
	private Car car;

	public WaxOff(Car car) {
		this.car = car;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				car.waitForWaxing();
				System.out.println("Wax Off ");
				TimeUnit.MICROSECONDS.sleep(200);
				car.buffed();
			}
		} catch (InterruptedException e) {
//			e.printStackTrace();
			System.out.println("WaxOff Interrupted"+e.toString());
		} finally {
			System.out.println("Ending Wax Off Task!");
		}
	}

}
