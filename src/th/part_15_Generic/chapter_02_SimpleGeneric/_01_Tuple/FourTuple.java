package th.part_15_Generic.chapter_02_SimpleGeneric._01_Tuple;

public class FourTuple<A, B, C, D> {
	//声明final类型，为了让对象具有只读功能
		public final A first;
		public final B second;
		
		public final C third;
		public final D fourth;
		
		public FourTuple(A a,B b,C c,D d){
			this.first=a;
			this.second=b;
			this.third=c;
			this.fourth=d;
		}
		
		public String toString(){
			return "First:"+first.getClass().getSimpleName()+",Second:"+second.getClass().getSimpleName()+
					"\nThree:"+third.getClass().getSimpleName()+",Four:"+fourth.getClass().getSimpleName();
		}
}
