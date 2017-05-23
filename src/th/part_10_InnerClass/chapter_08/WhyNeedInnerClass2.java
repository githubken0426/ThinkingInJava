package th.part_10_InnerClass.chapter_08;

public class WhyNeedInnerClass2 {
	class D{}
	abstract class E{}
	
	class Z extends D{
		E makeE(){
			return new E(){};
		}
	}
	
	
}
