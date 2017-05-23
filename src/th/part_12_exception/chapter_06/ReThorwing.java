package th.part_12_exception.chapter_06;

public class ReThorwing {
	public static void f() throws Exception {
		throw new Exception("Throw from f();");
	}
	public static void g() throws Exception {
		try {
			f();
		} catch (Exception e) {
			System.out.println("g():e.printStackTrace():");
			e.printStackTrace(System.out);
			throw e;
		}
	}
	
	public static void h() throws Exception {
		try {
			f();
		} catch (Exception e) {
			System.out.println("h():e.printStackTrace():");
			e.printStackTrace(System.out);
			throw (Exception)e.fillInStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		try {
//			g();
//		} catch (Exception e) {
//			e.printStackTrace(System.out);
//		}
		
		try {
			h();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
}
