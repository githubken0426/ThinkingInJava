package th.part_21_Concurrence.chapter_02._09ChangeCode;

public class SelfManager implements Runnable {
	private int countDown=5;
	private Thread t=new Thread(this);
	/**
	 * �������������̣߳����ܻ�������
	 * ��Ϊ��һ���߳̿��ܻ��ڹ���������֮ǰ��ʼִ�У�
	 * ����ζ�Ÿ�������ܻ���ʲ��ȶ�״̬�Ķ���
	 * ��������ѡ��Executor��ԭ��
	 */
	public SelfManager(){
		t.start();
	}
	public String toString(){
		return Thread.currentThread()+ "("+countDown+"),";
	}
	@Override
	public void run() {
		while(true){
			System.out.println(this);
			if(--countDown==0)
				return ;
		}
	}

	public static void main(String[] args) {
		for(int i=0;i<5;i++)
			new SelfManager();
	}
}
