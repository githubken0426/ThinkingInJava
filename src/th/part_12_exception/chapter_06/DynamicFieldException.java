package th.part_12_exception.chapter_06;

public class DynamicFieldException extends Exception {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		DynamicFields df = new DynamicFields(3);
		System.out.println(df);
		try {
			df.setField("d:", " A value of d");
			df.setField("number1:", 47);
			df.setField("number2:", 48);
			System.out.println(df);
		} catch (DynamicFieldException e) {
			e.printStackTrace();
		}
	}
}
