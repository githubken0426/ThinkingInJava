package th.part_12_exception.chapter_01;

public class FullConstructor {
	
	public static void f() throws MyException{
		System.out.println("throw MyException ");
		throw new MyException();
	}
	/**
	 * System.err 不会重定向，异常信息更容易看到。
	 * System.out 会被重定向
	 * @param args
	 * @throws 
	 * @date 2018年8月31日 下午2:00:54
	 */
	public static void main(String[] args){
		try {
			FullConstructor.f();
		} catch (MyException e) {
			//信息会输出到标准错误流(System.err)
			e.printStackTrace();
			e.printStackTrace(System.out);
		}
	}
}
