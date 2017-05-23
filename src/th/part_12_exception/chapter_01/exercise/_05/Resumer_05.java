package th.part_12_exception.chapter_01.exercise._05;

public class Resumer_05 {
	static int count=3;
	static void f()throws Exception{
		if(--count>0)
			throw new Exception();
	}
}
