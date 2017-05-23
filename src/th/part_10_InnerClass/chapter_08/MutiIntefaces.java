package th.part_10_InnerClass.chapter_08;

import th.part_10_InnerClass.chapter_08.WhyNeedInnerClass.A;
import th.part_10_InnerClass.chapter_08.WhyNeedInnerClass.B;
import th.part_10_InnerClass.chapter_08.WhyNeedInnerClass.X;
import th.part_10_InnerClass.chapter_08.WhyNeedInnerClass.Y;

public class MutiIntefaces {
	static void takesA(A a){}
	static void takesB(B b){}
	
	public static void main(String[] args) {
		X x=new WhyNeedInnerClass().new X();
		Y y=new WhyNeedInnerClass().new Y();
		takesA(x);
		takesA(y);
		
		takesB(x);
		takesB(y.makeB());
	}
}
