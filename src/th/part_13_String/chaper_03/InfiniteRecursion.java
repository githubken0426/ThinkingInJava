package th.part_13_String.chaper_03;

public class InfiniteRecursion {
	
	public InfiniteRecursion(){}
	
	public InfiniteRecursion(String name){
		this.name=name;
	}
	/**
	 * 当编译器看到this+的时候，就做类型转换。
	 * this是InfiniteRecursion类型，会调用InfiniteRecursion的toString()方法
	 * 产生异常，递归调用。
	 */
	public String toString(){
		//return "内存地址:"+this+"\n";
		return "内存地址:"+super.toString()+"\n";
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
