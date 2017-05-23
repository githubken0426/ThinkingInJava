package th.part_15_Generic.chapter_02_SimpleGeneric._01_Tuple;

import th.part_15_Generic.chapter_02_SimpleGeneric._01_Tuple.AllClass.*;

public class TupleMain {
	
	public static <A,B> TwoTuple<A,B> test(A a,B b){
		return new TwoTuple<A,B>(a,b);
	}
	
	public static TwoTuple<String,Integer> f(){
		return new TwoTuple<String,Integer>("Hi!",47);
	}
	
	public static ThreeTuple<AllClass.Amphibian,AllClass.Student,AllClass.Vehicle> g(){
		return new ThreeTuple<AllClass.Amphibian,AllClass.Student,AllClass.Vehicle>
		(new Amphibian(),new Student(),new Vehicle());
	}
	
	public static FourTuple<AllClass.Amphibian,AllClass.Student,AllClass.Vehicle,String> h(){
		return new FourTuple<AllClass.Amphibian,AllClass.Student,AllClass.Vehicle,String>
		(new Amphibian(),new Student(),new Vehicle(),"hi");
	}
	
	public static void main(String[] args) {
		TwoTuple<String,Integer> f=f();
		System.out.println(f);
//		f.first="";first是final 只对类型
		ThreeTuple<AllClass.Amphibian,AllClass.Student,AllClass.Vehicle> g=g();
		System.out.println(g);
	}
}
