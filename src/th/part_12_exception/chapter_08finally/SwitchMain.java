package th.part_12_exception.chapter_08finally;

public class SwitchMain {
	private static SwitchClass sc=new SwitchClass();
	
	private static void f() throws OnException,OffException{
		System.out.println("this is f();");
		throw new OnException();
	}
	
	public static void main(String[] args) {
		try {
			sc.on();
			f();
			//sc.off();
		} catch (OnException e) {
			System.out.println("OnException");
			//sc.off();
			e.printStackTrace();
		}catch(OffException e){
			System.out.println("OffException");
			e.printStackTrace();
		}finally {
			sc.off();
		}
	}

}
