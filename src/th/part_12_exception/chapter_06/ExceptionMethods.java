package th.part_12_exception.chapter_06;

public class ExceptionMethods {

	public static void main(String[] args) {
		try {
			throw new Exception("My Exception");
		} catch (Exception e) {
			System.out.println("e.getMessage():"+e.getMessage());
			System.out.println("e.getLocalizedMessage():"+e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

}
