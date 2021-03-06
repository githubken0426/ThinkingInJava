package th.part_21_Concurrence.chapter_02._09ChangeCode;

/**
 * 使用内部类
 * @author Administrator
 *
 */
public class InnerThread1 {
	private int countDown=5;
	private Inner inner;
	
	class Inner extends Thread{
		Inner(String name){
			super(name);
			start();
		}
		
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
	}
	
	public InnerThread1(String name){
		inner =new Inner(name);
	}
}
