package th.part_10_InnerClass.chapter_11;

/**
 * 10.11
 * �ֲ��ڲ���
 * 
 * @author ken
 * 2016-9-26 ����08:30:03
 */
public class LoclInnerClass {
	private int count =0;
	Counter getCounter(final String name){
		class LocalCount implements Counter{
			public LocalCount(){
				System.out.println("LocalCount!");
			}
			@Override
			public int next() {
				System.out.print(name);
				return count++;
			}
		}
		return new LocalCount();
	}
	Counter getCounter2(final String name){
		return new Counter(){
			{System.out.println("Counter");}//������
			@Override
			public int next() {
				System.out.print(name);
				return count++;
			}
		};
	}
	
	/**
	 * �ֲ��ڲ��ࣺ����Ҫһ�������Ĺ��죬������Ҫ���ع�����ʱ��������Ҫ�ܶ���ڲ������
	 * �����ڲ��ࣺ�����ڲ����������ʵ����ʼ��
	 * @param args
	 * 2016-9-26 ����08:49:50
	 */
	public static void main(String[] args) {
		LoclInnerClass local=new LoclInnerClass();
		Counter counter=local.getCounter("Local Inner!"),
				counter2=local.getCounter2("Anonymous !"); 
		for(int i=0;i<5;i++){
			System.out.println(counter.next());
			System.out.println(counter2.next());
		}
	}
}
