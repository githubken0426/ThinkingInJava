package th.part_21_Concurrence.chapter_02._12Form;

public class UnresponsiveUI {
	private volatile double d=1;
	
	public UnresponsiveUI()throws Exception{
		while(true)
			d+=(Math.PI+Math.E)/d;//E:��Ȼ����
//		System.in.read();//���벻��ִ��
	}
}
