package th.part_21_Concurrence.chapter_02._11Join;

/**
 * �߳�����:ָһ���߳���ִ�й�������ͣ���Եȴ�ĳ�������Ĵ�����
 * @author Administrator
 *
 */
public class JoinMain {
	public static void main(String[] args) {
		Sleeper sleepy = new Sleeper("Sleepy",6);
		Joiner joiner=new Joiner("Joiner",sleepy);
		sleepy.interrupt();
		
		/**
		 * Joiner����interrupt()�������ȵ�����join()����ִ����ϣ�Joiner�Żᱻִ���ж��쳣
		 * Sleeper����interrupt()����,
		 * ���Կ���ֻҪ����interrupted()����������ִ���ж��쳣
		 */
//		joiner.interrupt();
		
	
		
//		Sleeper sleepy1=new Sleeper("Sleepy1",10);
//		Joiner dopey=new Joiner("Joiner sleepy1",sleepy1);
//		dopey.interrupt();
	}
}
