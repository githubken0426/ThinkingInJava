package concurrent.share._08join;

/**
 * 线程阻塞:指一个线程在执行过程中暂停，以等待某个条件的触发。
 * @author Administrator
 *
 */
public class JoinMain {
	public static void main(String[] args) {
		Sleeper sleepy = new Sleeper("Sleepy",6);
		new Join("Joiner",sleepy);
//		sleepy.interrupt();
	}
}
