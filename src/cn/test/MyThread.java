package cn.test;


public class MyThread implements Runnable {

	@Override
	public void run() {
		throw new RuntimeException();
	}

}
