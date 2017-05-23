package th.part_10_InnerClass.chapter_11;

/**
 * 10.11
 * 局部内部类
 * 
 * @author ken
 * 2016-9-26 上午08:30:03
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
			{System.out.println("Counter");}//构造器
			@Override
			public int next() {
				System.out.print(name);
				return count++;
			}
		};
	}
	
	/**
	 * 局部内部类：当需要一个命名的构造，或者需要重载构造器时。或者需要很多该内部类对象
	 * 匿名内部类：匿名内部类仅仅进行实例初始化
	 * @param args
	 * 2016-9-26 上午08:49:50
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
