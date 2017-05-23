package th.part_12_exception.chapter_04;


public class ParcelLogger {
	public static void main(String[] args) {
		try {
			throw new LoggerException();
		} catch (LoggerException e) {
			System.err.println("Caught:"+e);
		}
		
		try {
			throw new LoggerException();
		} catch (LoggerException e) {
			System.err.println("Caught:"+e);
		}
	}
}
