package th.part_15_Generic.chapter_02_SimpleGeneric._01_Tuple;

/**
 * 3维元组
 * @author Administrator
 * 2015年9月18日
 * @param <A>
 * @param <B>
 * @param <C>
 */
public class ThreeTuple<A,B,C> extends TwoTuple<A,B> {
	public final C third;
	
	public ThreeTuple(A a, B b,C c) {
		super(a, b);
		this.third=c;
	}
	public String toString(){
		return "First:"+first.getClass().getSimpleName()+",Second:"+second.getClass().getSimpleName()+
				",Three:"+third.getClass().getSimpleName();
	}
}
