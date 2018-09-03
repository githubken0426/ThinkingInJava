package th.part_12_exception.chapter_06._03Chain;

/**
 * 异常链：在捕获一个异常后抛出另一个异常，并且希望把原始异常信息保存下来，这就是异常链。
 * 
 * Throwable可以通过构造器接受cause参数来追踪原始异常。这个cause就是异常原由，代表着原始异常，
 * 即使在当前位置创建并抛出行的异常，也可以通过这个cause追踪到异常最初发生的位置。
 * 
 * 只有Error,Exception,RuntimeException提供了带cause参数的构造器，其他的所以异常就只有通过initCause()来设置cause了。
 * @ClassName: DynamicFieldException 
 * @author ken 
 * @date 2018年8月31日 下午3:15:58
 */
public class DynamicFieldException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		DynamicFields df = new DynamicFields(1);
		System.out.println(df);
		try {
			df.setField("d:", " A value of d");
			df.setField("number1:", 47);
			df.setField("number2:", null);
			System.out.println(df);
		} catch (DynamicFieldException e) {
			//printStackTrace()自动调用getCause();
			e.printStackTrace();
		}
	}
}
