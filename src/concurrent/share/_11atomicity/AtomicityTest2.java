package concurrent.share._11atomicity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest2 implements Runnable{
	
	private int i=0;//��������volatile����,���ڿ���������
	/**
	 * ��ȻevenCrement()������ͬ���ģ�getValue()������return iҲ��ԭ���Բ�����
	 * ����ȱ��ͬ��ʹ��i���м�״̬ʱ(JVM get��putʱ)�򱻶�ȡ
	 * @return
	 */
	public int getValue(){//synchronized
		return i;
	}
	
	private synchronized void evenCrement(){
		++i;
		++i;
	}
	
	@Override
	public void run() {
		while(true)
			evenCrement();
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService exe=Executors.newScheduledThreadPool(2);
		AtomicityTest2 atom = new AtomicityTest2();
		exe.execute(atom);
		while(true){
			int val=atom.getValue();
			if(val %2!=0){
				System.out.println("����������"+val);
				System.exit(0);
			}
		}
	}
	
}
