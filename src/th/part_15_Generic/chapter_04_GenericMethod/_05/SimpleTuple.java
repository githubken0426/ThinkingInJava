package th.part_15_Generic.chapter_04_GenericMethod._05;

import th.part_15_Generic.chapter_02_SimpleGeneric._01_Tuple.ThreeTuple;
import th.part_15_Generic.chapter_02_SimpleGeneric._01_Tuple.TwoTuple;

/**
 * ��Ԫ��
 * @author Administrator
 * 2015��9��25��
 */
public class SimpleTuple {
	public static <A,B> TwoTuple<A,B> tuple(A a,B b){
		return new TwoTuple(a,b);
	}
	
	public static <A,B,C> ThreeTuple<A,B,C> tuple(A a,B b,C c){
		return new ThreeTuple(a,b,c);
	}
}
