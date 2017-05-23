package th.part_21_Concurrence.chapter_02._12Form;

public class UnresponsiveUI {
	private volatile double d=1;
	
	public UnresponsiveUI()throws Exception{
		while(true)
			d+=(Math.PI+Math.E)/d;//E:自然对数
//		System.in.read();//代码不会执行
	}
}
