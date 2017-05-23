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
			System.out.println("Jointry:执行sleeper.join()！");
			sleeper.join();
			System.out.println("Join继续执行其他方法！");
		} catch (InterruptedException e) {
//			e.printStackTrace();
			System.out.println("Join catch:"+this.getName()+" Interrputed");
		}
	}
}
