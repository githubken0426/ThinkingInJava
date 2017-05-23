
package th.part_20_Annotation.chapter_01_Base._01;

@Test
public class Testable {
	private @Test final int id=19;
	
	@Test
	public Testable(){}
	public void execute(){
		System.out.println("executing");
	}
	
	@Test void testExecute(@Test String str){
		execute();
	}
	 
	public static void main(String[] args) {
		@Test int age=10;
		new Testable().testExecute("≤‚ ‘"+age);
	}
}
