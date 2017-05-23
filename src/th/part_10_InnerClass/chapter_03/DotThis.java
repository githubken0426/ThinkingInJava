package th.part_10_InnerClass.chapter_03;

/**
 * 10.3 ʹ��.this��.new
 * @author Administrator
 *
 * 2016-9-19 ����05:10:30
 */
public class DotThis {
	void f(){
		System.out.println("DotThis f()");
	}
	
	/**
	 * �ڲ��������ⲿ���������ã�����ʹ��"�ⲿ������.this"
	 * @author Administrator
	 *
	 * 2016-9-19 ����05:16:15
	 */
	public class Inner{
		public DotThis outer(){
			//"this" would be inner`s "this"
			return DotThis.this;
		}
	}
	
	public DotThis outer2(){
		//"this" would be inner`s "this"
		return DotThis.this;
	}
	
	public Inner inner(){
		return new Inner();
	}
	
	
	public static void main(String[] args) {
		DotThis dot=new DotThis();
		DotThis.Inner inner=dot.inner();
		inner.outer().f();
	}
}
