package th.part_21_Concurrence.chapter_02._01Runnable;

/**
 * ��������������һ������ִ�е�Ԫ��Ϊ�̣߳�thread����
 * ���̻�ӵ��һ��˽�е������ַ�ռ䣬�ÿռ���ܱ������������̷߳���
 */
/**
 * ʵ������������ʵ��Runable�ӿڣ�һ������Ϊjavaֻ֧�ֵ��̳У��̳���Thread����޷��ټ����̳������࣬
 * ����Runable�ӿ���Ҫʵ��run��������һ����ͨ��������Կ���ʵ��Runable�ӿڲ��������Ķ��߳�
 * @author Administrator
 * 2016-1-18 ����01:48:03
 * ���п���֤��ȷ���ԣ�ʵ���Ͼ��в���ȷ����
 */

public class LiftOff implements Runnable {
	protected int countDown=10;
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
		/**
		 * ֱ�ӵ���run()��ʵ�ǵ��̵߳�һ������
		 * �˴�Ϊ"main"�߳�
		 */
		lift.run();
		System.out.println("________________________________");
		for(int i =0;i<3;i++){
			Thread t=new Thread(new LiftOff());
			t.start();
		}
		
	}
}
