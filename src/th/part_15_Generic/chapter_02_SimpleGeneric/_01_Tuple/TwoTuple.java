package th.part_15_Generic.chapter_02_SimpleGeneric._01_Tuple;

/**
 * 2维元组
 * 
 * 元组可以一次调用，返回多个不同的对象
 * Tuple元组是不可变list。一旦创建了一个tuple就不能以任何方式改变它（python）
 * 
 * @author ken
 * 2015年9月18日
 * @param <A>
 * @param <B>
 */
public class TwoTuple<A,B> {
	//声明final类型，为了让对象具有只读功能
	public final A first;
	public final B second;
	
	public TwoTuple(A a,B b){
		this.first=a;
		this.second=b;
	}
	
	public String toString(){
		return "First:"+first+",Second:"+second.getClass().getCanonicalName();
	}
}
