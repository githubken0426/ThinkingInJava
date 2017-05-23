package concurrent.share._01runnable;


/**
 * �� ��������
 * @author Administrator
 * 2016-1-18 ����01:48:03
 * ���п���֤��ȷ���ԣ�ʵ���Ͼ��в���ȷ����
 */

public class LiftOff implements Runnable {
	protected int countDown=3;
	private static int taskCount=0;
	private final int id=taskCount++;
	
	public LiftOff(){}
	public LiftOff(int countDown){
		this.countDown=countDown;
	}
	public String status(){
		return Thread.currentThread()+":#id="+ id+",("+(countDown>0?countDown:"LiftOff")+"),";
	}
	@Override
	public void run() {
		while (countDown-->0) {
			System.out.println(status());
			/**
			 * yield():���̵߳�������һ�ֽ���:ѡ���Եģ�
			 * ��ͣ��ǰ�̣߳���cpu����ִ�������߳�(���������߳�)��
			 * ��ֻ����ͬ���ȼ����߳���ִ�еĻ���
			 */
			Thread.yield();
		}
	}
	
	public static void main(String[] args) {
		LiftOff lift=new LiftOff();
		lift.run();
		System.out.println("I an main!\n");
	}
}
