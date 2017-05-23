package th.part_12_exception.chapter_09;

public class ClassExceptions {
	
	public class BaseBallException extends Exception{}
	
	public class Foul extends BaseBallException{}
	
	public class Strike extends BaseBallException{}
	
	public class StormException extends Exception{}
	
	public class RaineOutException extends StormException{}
	
	public class PopFoul extends Foul{}
}
