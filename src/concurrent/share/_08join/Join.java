package concurrent.share._08join;

public class Join extends Thread {
	private Sleeper sleeper;
	
	public Join(String name,Sleeper sleeper){
		super(name);
		this.sleeper=sleeper;
		start();
	}
	
	public void run(){
		try {
			System.out.println("Jointry:ִ��sleeper.join()��");
			sleeper.join();
			System.out.println("Join����ִ������������");
		} catch (InterruptedException e) {
//			e.printStackTrace();
			System.out.println("Join catch:"+this.getName()+" Interrputed");
		}
	}
}
