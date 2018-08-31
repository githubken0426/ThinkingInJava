package th.part_12_exception.chapter_06._03Chain;

/**
 * 异常链：在捕获一个异常后抛出另一个异常，并且希望把原始异常信息保存下来，这就是异常链。
 * Throwable可以通过构造器接受cause参数来追踪原始异常。
 * @ClassName: DynamicFieldException 
 * @Description: 
 * @author ken 
 * @date 2018年8月31日 下午3:15:58
 */
public class DynamicFieldException extends Exception {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		DynamicFields df = new DynamicFields(3);
		System.out.println(df);
		try {
			df.setField("d:", " A value of d");
			df.setField("number1:", 47);
			df.setField("number2:", null);
			System.out.println(df);
		} catch (DynamicFieldException e) {
			e.printStackTrace();
		}
	}
}
