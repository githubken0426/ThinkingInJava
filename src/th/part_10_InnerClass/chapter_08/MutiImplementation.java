package th.part_10_InnerClass.chapter_08;

import th.part_10_InnerClass.chapter_08.WhyNeedInnerClass2.D;
import th.part_10_InnerClass.chapter_08.WhyNeedInnerClass2.E;
import th.part_10_InnerClass.chapter_08.WhyNeedInnerClass2.Z;

public class MutiImplementation {
	static void takesD(D d){}
	static void takesE(E e){}
	
	public static void main(String[] args) {
		Z z=new WhyNeedInnerClass2().new Z();
		takesD(z);
		takesE(z.makeE());
	}
}
