package io.input.piped;

public class Piped {
	/**
	 * PipedInputStream类与PipedOutputStream类用于不同线程之间的相互通信.
	 * 一个PipedInputStream实例对象必须和一个PipedOutputStream实例对象进行连接而产生一个通信管道.
	 * PipedOutputStream可以向管道中写入数据,PipedIntputStream可以读取PipedOutputStream向管道中写入的数据.
	 * 
	 * 这两个类主要用来完成线程之间的通信.
	 * 一个线程的PipedInputStream对象能够从另外一个线程的PipedOutputStream对象中读取数据.
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
}
