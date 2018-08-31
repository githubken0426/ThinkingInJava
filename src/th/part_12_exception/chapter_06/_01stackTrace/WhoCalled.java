package th.part_12_exception.chapter_06._01stackTrace;

public class WhoCalled {
	static void f() {
		try {
			throw new Exception();
		} catch (Exception e) {
			for (StackTraceElement ele : e.getStackTrace()) {
				System.out.println(ele);
			}
		}
	}
	static void g(){
		f();
	}
	static void h(){
		g();
	}
	public static void main(String[] args) {
		f();
		System.out.println("------------------");
		g();
		System.out.println("------------------");
		h();
	}

}
