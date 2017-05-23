package th.part_10_InnerClass.chapter_08._01Closure;


public class Callee2 extends MyIncrement{
	private int i=0;
	
	public void increment() {
		super.increment();
		i++;
		System.out.println("Callee2.increment():"+i);
	}
	
	private class Closure implements Incrementable{
		/**
		 * ָ���ⲿ�෽��
		 * ����õ�һ�����޵ݹ�
		 */
		@Override
		public void increment() {
			System.out.println("Closure.increment():"+i);
			Callee2.this.increment();
//			new Callee2().increment();
		}
	}
	
	Incrementable getCallbackReference(){
		return new Closure();
	}
	
	
}
