package th.part_10_InnerClass.chapter_03;

/**
 * 10.3 使用.this和.new
 * @author Administrator
 *
 * 2016-9-19 下午05:10:30
 */
public class DotThis {
	void f(){
		System.out.println("DotThis f()");
	}
	
	/**
	 * 内部类生成外部类对象的引用，可以使用"外部类名称.this"
	 * @author Administrator
	 *
	 * 2016-9-19 下午05:16:15
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
