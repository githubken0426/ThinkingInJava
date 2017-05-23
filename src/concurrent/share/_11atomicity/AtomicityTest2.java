package concurrent.share._11atomicity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest2 implements Runnable{
	
	private int i=0;//变量不是volatile修饰,存在可视性问题
	/**
	 * 虽然evenCrement()方法是同步的，getValue()方法的return i也是原子性操作，
	 * 但是缺少同步使得i在中间状态时(JVM get或put时)候被读取
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
				System.out.println("发现奇数："+val);
				System.exit(0);
			}
		}
	}
	
}
