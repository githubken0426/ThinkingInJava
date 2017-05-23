package th.part_19_ENUM.chapter_10_constants;

public class Test {
	public static void main(String[] args) {
		try {
			System.out.println(""+(false || true));
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
			for (StackTraceElement ele : e.getStackTrace()) {
				System.out.println(ele.getMethodName());
			}
		}
	}
}
