package th.part_12_exception.chapter_01;

public class MyException2 extends Exception{
	private static final long serialVersionUID = 1L;
	
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
	/**
	 * 重写Throwable的getMessage()方法
	 */
	public String getMessage(){
		return "Detail Message:"+super.getMessage();
	}
	
	/**
	 * 继承类应该override(覆盖)getLocalizedMessage()
	 * 此方法来提供一个针对地区方言的错误信息
	 * 默认getMessage()、getLocalizedMessage()两者一致
	 */
	@Override
	public String getLocalizedMessage() {
		return super.getLocalizedMessage();
	}
	
}
