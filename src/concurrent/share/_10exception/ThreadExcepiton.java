package concurrent.share._10exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExcepiton {
	static void test() {
		ExecutorService exe = Executors.newCachedThreadPool();
		
		exe.execute(new Runnable() {
			@Override
			public void run() {
				throw new UnsupportedOperationException();
			}
		});
		exe.shutdown();
	}
	static void testTry() {
		ExecutorService exe = Executors.newCachedThreadPool();
		try {
			exe.execute(new Runnable() {
				@Override
				public void run() {
					throw new UnsupportedOperationException();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Catche Exception");
		}finally{
			exe.shutdown();
		}
	}
	public static void main(String[] args) {
//		test();
		testTry();
	}
}
