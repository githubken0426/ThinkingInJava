package th.part_14_TypeInfo.chapter_09._03anonymous;

import th.part_14_TypeInfo.chapter_09.CallHiddenMethod;
import th.part_14_TypeInfo.chapter_09.InteA;

/**
 * 访问匿名类
 * @author Administrator
 * 2016-3-31 上午10:30:19
 *
 */
public class AnonymousImplementation {
	public static void main(String[] args)throws Exception {
		InteA a=AnonymousA.makeA();
		a.f();
		a.g();
		//getCanonicalName()输出null
		System.out.println("getCanonicalName():"+a.getClass().getCanonicalName());
		//getSimpleName()无任何输出
		System.out.println("getSimpleName():"+a.getClass().getSimpleName());
		//getSimpleName()输出：匿名类名$1，应该是默认给个编号
		System.out.println("getName():"+a.getClass().getName());
		CallHiddenMethod.getHiddenMethod(a,"c");
		CallHiddenMethod.getHiddenMethod(a,"u");
		CallHiddenMethod.getHiddenMethod(a,"v");
	}
}
