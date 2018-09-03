package th.part_12_exception.chapter_06._03Chain;

public class ExceptionChain {
	public static void f() throws MyException2 {
		try {
			g();
		} catch (MyException1 e) {
			e.printStackTrace();
			/**
			 * 将Exception当作cause传递进去，这样能够获取MyException1的信息，形成一条异常链
			 */
			throw new MyException2(e);
		}
	}

	public static void g() throws MyException1 {
		throw new MyException1();
	}
	
	public static void main(String[] args) {
		try {
			ExceptionChain.f();
		} catch (MyException2 e) {
			e.printStackTrace();
		}
	}
}

class MyException1 extends Exception {
	private static final long serialVersionUID = 1L;
}

class MyException2 extends Exception {
	private static final long serialVersionUID = 1L;

	MyException2(Throwable throwable) {
		super(throwable);
	}

	MyException2() {
		super();
	}
}