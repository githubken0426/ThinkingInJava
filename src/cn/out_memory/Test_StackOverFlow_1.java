package cn.out_memory;

public class Test_StackOverFlow_1 {
	private  int stackLength=0;
	public  void stackOverFlow(){
		++stackLength;
		stackOverFlow();
	}
	public static void main(String[] args) {
		Test_StackOverFlow_1 t=new Test_StackOverFlow_1();
		try {
			t.stackOverFlow();
		} catch (Throwable e) {
			System.out.println("stack length:"+ t.stackLength);
			e.printStackTrace();
		}
	}
}
