package th.part_14_TypeInfo.chapter_02._02;

public class CountInteger {
	private static long count;
	/**
	 * count设为static类型,变量是在jvm加载类的时候加载，而且只加载一次
	 * 当然有调用static变量的时候，还是会加载多次
	 */
	private final long id=count++;
	
	public String toString(){
		return Long.toString(id);
	}
}
