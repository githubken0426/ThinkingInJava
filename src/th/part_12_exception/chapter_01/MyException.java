package th.part_12_exception.chapter_01;

public class MyException extends Exception {
	private static final long serialVersionUID = 1L;

	public MyException(){}
	
	public MyException(String msg){
		super(msg);
	}
}
