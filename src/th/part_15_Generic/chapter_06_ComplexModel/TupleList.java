package th.part_15_Generic.chapter_06_ComplexModel;

import java.util.ArrayList;

import th.part_15_Generic.chapter_02_SimpleGeneric._01_Tuple.AllClass;
import th.part_15_Generic.chapter_02_SimpleGeneric._01_Tuple.FourTuple;
import th.part_15_Generic.chapter_02_SimpleGeneric._01_Tuple.TupleMain;

/**
 * 构建复杂模型
 * @author Administrator
 * 2015年9月28日
 * @param <A>
 * @param <B>
 * @param <C>
 * @param <D>
 */
public class TupleList<A, B, C, D> extends ArrayList<FourTuple<A, B, C, D>> {
	public static void main(String[] args) {
		TupleList<AllClass.Amphibian,AllClass.Student,AllClass.Vehicle,String> t1=
				new TupleList<AllClass.Amphibian,AllClass.Student,AllClass.Vehicle,String>();
		t1.add(TupleMain.h());
		t1.add(TupleMain.h());
		
		for (FourTuple<AllClass.Amphibian,AllClass.Student,AllClass.Vehicle,String> fourTuple : t1) {
			System.out.println(fourTuple);
		}
	}
}
