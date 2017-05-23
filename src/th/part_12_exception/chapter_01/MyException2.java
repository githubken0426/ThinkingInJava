package th.part_12_exception.chapter_01;

public class MyException2 extends Exception{
	private int x;
	public MyException2(){}
	
	public MyException2(String msg){
		super(msg);
	}
	
	public MyException2(String msg,int x){
		super(msg);
		this.x=x;
	}
	
	public int value(){
		return x;
	}
	
	public String getMessage(){
		return "Detail Message:"+super.getMessage();
	}
}
