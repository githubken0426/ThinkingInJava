package concurrent.share._08join;

/**
 * �߳�����:ָһ���߳���ִ�й�������ͣ���Եȴ�ĳ�������Ĵ�����
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
