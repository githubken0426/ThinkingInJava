package th.part_15_Generic.chapter_03_GenericInterface;

import th.util.Generator;

public class Fibonacci implements Generator<Integer> {
	private int count;

	@Override
	public Integer next() {
		int result=fib(count++);
		return result;
	}

	private int fib(int n){
		if(n<2){
			return 1;
		} 
		return fib(n-2)+fib(n-1);
	}
	
	/**
	 * Fibonacci���еĳ�Ա����ȫ��int�������ͣ����Ͳ���ȷ��Integer���ͣ���˵�����;߱��Զ�װ�����
	 * ��Ҳ˵����java���͵ľ�����:���������޷���Ϊ���Ͳ���
	 * @param args
	 *	2015��9��24��
	 */
	public static void main(String[] args) {
		Fibonacci fib=new Fibonacci();
		for(int i=0;i<18;i++){
			System.out.println(fib.next());
		}
	}
}
