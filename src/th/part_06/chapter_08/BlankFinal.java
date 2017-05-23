package th.part_06.chapter_08;

public class BlankFinal {
	final int a;
	
	final Value value;
	/**
	 * 空白final必须在某处（如构造器中）赋值
	 */
	public BlankFinal(){
		a=1;
		value=new Value();
	}
	
}
