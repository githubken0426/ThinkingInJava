package th.part_14_TypeInfo.chapter_05;

import th.part_14_TypeInfo.exercise._09.Base;
import th.part_14_TypeInfo.exercise._09.Derived;


public class FamilyVsExactType {
	static void test(Object obj){
		System.out.println("obj.getClass():"+obj.getClass());
		System.out.println("obj.instanceof Base:"+(obj instanceof Base));
		System.out.println("obj.instanceof Derived:"+(obj instanceof Derived));
		
		System.out.println("Base.class.isInstance(obj):"+Base.class.isInstance(obj));
		System.out.println("Derived.class.isInstance(obj):"+Derived.class.isInstance(obj));
		
		System.out.println("obj.getClass()==Base.class:"+(obj.getClass()==Base.class));
		System.out.println("obj.getClass()==Derived.class:"+(obj.getClass()==Derived.class));
		
		System.out.println("obj.getClass().equals(Base.class):"+(obj.getClass().equals(Base.class)));
		System.out.println("obj.getClass().equals(Derived.class):"+(obj.getClass().equals(Derived.class)));
	}
	
	public static void main(String[] args) {
		test(new Base());
		System.out.println("-------------------------------------------");
		test(new Derived());
		
		
	}
}
