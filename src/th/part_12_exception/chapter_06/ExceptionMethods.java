package th.part_12_exception.chapter_06;

public class ExceptionMethods {

	/**
	 * 继承类应该override(覆盖)getLocalizedMessage()
	 * 此方法来提供一个针对地区方言的错误信息
	 * 默认getMessage()、getLocalizedMessage()两者一致
	 */
	
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
