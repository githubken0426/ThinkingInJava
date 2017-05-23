package th.part_10_InnerClass.chapter_08._01Closure;


public class Callee1 implements Incrementable {
	private int i=0;
	@Override
	public void increment() {
		i++;
		System.out.println("Callee1.increment():"+i);
	}

}
