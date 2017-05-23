package th.part_21_Concurrence.chapter_02._11Join;

public class Joiner extends Thread {
	private Sleeper sleeper;
	
	public Joiner(String name,Sleeper sleeper){
		super(name);
		this.sleeper=sleeper;
		start();
	}
	
	/**
	 * �߳����������һ�߳�join����ʱ����ʾ�����߳�����
	 * ֱ����һ�߳���ֹʱ(ִ����ϡ������������������жϵȣ���ִ�� 
	 * 
	 * ����interrupt��������ǰ�̲߳��ڱ����𣬺���һ�߳�һ�����
	 * 
	 * ������һ���߳���(�˴�ΪJoiner)����interrupt��������������߳�һ����־����ʾ�ж�״̬
	 * ���Ǳ��쳣����ʱ�򣬻���������־�������쳣�����һֱΪfalse
	 */
	public void run(){
		try {
			System.out.println("Joinerִ��sleeper.join()��");
			sleeper.join();
//			System.out.println(sleeper.getName()+" sleeper.join()ִ����ϣ�");
			System.out.println("Joiner����ִ������������");
		} catch (InterruptedException e) {
//			e.printStackTrace();
			System.out.println("Joiner:"+this.getName()+" Interrputed");
		}
	}
}
