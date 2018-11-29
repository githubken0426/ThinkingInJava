package io.input.piped;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.IoUtil;

public class Piped {
	/**
	 * PipedInputStream类与PipedOutputStream类用于不同线程之间的相互通信.
	 * 一个PipedInputStream实例对象必须和一个PipedOutputStream实例对象进行连接而产生一个通信管道.
	 * PipedOutputStream可以向管道中写入数据,PipedIntputStream可以读取PipedOutputStream向管道中写入的数据.
	 * 
	 * 这两个类主要用来完成线程之间的通信. 一个线程的PipedInputStream对象能够从另外一个线程的PipedOutputStream对象中读取数据.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Receiver receive = new Receiver();
			PipedInputStream input=receive.getInputStream();
			Sender sender = new Sender();
			PipedOutputStream output=sender.getOutputStream();
			output.connect(input);
			ExecutorService executor=Executors.newCachedThreadPool();
			executor.execute(sender);
			executor.execute(receive);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static class Receiver implements Runnable {
		private PipedInputStream input = new PipedInputStream();

		public PipedInputStream getInputStream() {
			return input;
		}

		@Override
		public void run() {
			try {
				byte[] bt = new byte[1024];
				int length = input.read(bt);
				System.out.println(new String(bt, 0, length));
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	static class Sender implements Runnable {
		private PipedOutputStream output = new PipedOutputStream();

		public PipedOutputStream getOutputStream() {
			return output;
		}

		@Override
		public void run() {
			try {
				File file = new File(IoUtil.INPUT_PATH);
				InputStream input = new BufferedInputStream(new FileInputStream(file));
				byte[] by = new byte[1024];
				int postion = 0;
				while ((postion = input.read(by)) != -1)
					output.write(by, 0, postion);
				output.close();
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
