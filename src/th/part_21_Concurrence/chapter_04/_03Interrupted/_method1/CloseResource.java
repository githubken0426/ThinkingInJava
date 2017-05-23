package th.part_21_Concurrence.chapter_04._03Interrupted._method1;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import th.part_21_Concurrence.chapter_04._03Interrupted.IOBlocked;

/**
 * 对包含有I/O操作的线程，不能中断操作。
 * 这点对web程序关乎厉害
 * 可以通过关闭在任务上发生阻塞的底层资源
 * @author Administrator
 *
 */
public class CloseResource {
	public static void main(String[] args) throws Exception {
		ExecutorService exe=Executors.newCachedThreadPool();
		ServerSocket server=new ServerSocket(8080);
		@SuppressWarnings("resource")
		InputStream input=new Socket("localhost",8080).getInputStream();
		
		exe.execute(new IOBlocked(input));
//		exe.execute(new IOBlocked(System.in));
		
		TimeUnit.MILLISECONDS.sleep(100);
		System.out.println("Shutting down all threads!");
		//shutdownNow会发送一个中断操作
		exe.shutdownNow();
		
		TimeUnit.SECONDS.sleep(2);
		System.out.println("Closing "+input.getClass().getName());
		input.close();
		
		TimeUnit.SECONDS.sleep(2);
//		System.out.println("Closing "+System.in.getClass().getName());
//		System.in.close();
		
		server.close();
		
	}
}
