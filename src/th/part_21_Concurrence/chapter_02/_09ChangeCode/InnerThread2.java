package th.part_21_Concurrence.chapter_02._09ChangeCode;
/**
 * 使用匿名内部类
 * @author Administrator
 *
 */
public class InnerThread2 {
	private int countDown=5;
	private Thread t;
	
	public InnerThread2(String name){
//		t=
		new Thread(name){
			public void run(){
				try {
					while(true){
						System.out.println(this);
						if(--countDown==0)return;
						sleep(10);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.out.println("Interrupter");
				}
			}
			
			public String toString(){
				return getName()+":"+countDown;
			}
		}.start();
//		t.start();
	}
}
