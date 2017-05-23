package th.part_14_TypeInfo.chapter_09._02inner;

import th.part_14_TypeInfo.chapter_09.CallHiddenMethod;
import th.part_14_TypeInfo.chapter_09.InteA;

/**
 * 访问内部类
 * @author Administrator
 * 2016-3-31 上午10:30:37
 *
 */
public class InnerImplementnation {
	public static void main(String[] args) throws Exception {
		InteA a=InnerA.makeA();
		a.f();
		a.g();
		System.out.println(a.getClass().getCanonicalName());
		System.out.println("getSimpleName():"+a.getClass().getSimpleName());
		System.out.println("getName():"+a.getClass().getName());
		
		CallHiddenMethod.getHiddenMethod(a,"c");
		CallHiddenMethod.getHiddenMethod(a,"u");
		CallHiddenMethod.getHiddenMethod(a,"v");
	}
}
