package th.part_14_TypeInfo.chapter_09._03anonymous;

import th.part_14_TypeInfo.chapter_09.CallHiddenMethod;
import th.part_14_TypeInfo.chapter_09.InteA;

/**
 * ����������
 * @author Administrator
 * 2016-3-31 ����10:30:19
 *
 */
public class AnonymousImplementation {
	public static void main(String[] args)throws Exception {
		InteA a=AnonymousA.makeA();
		a.f();
		a.g();
		//getCanonicalName()���null
		System.out.println("getCanonicalName():"+a.getClass().getCanonicalName());
		//getSimpleName()���κ����
		System.out.println("getSimpleName():"+a.getClass().getSimpleName());
		//getSimpleName()�������������$1��Ӧ����Ĭ�ϸ������
		System.out.println("getName():"+a.getClass().getName());
		CallHiddenMethod.getHiddenMethod(a,"c");
		CallHiddenMethod.getHiddenMethod(a,"u");
		CallHiddenMethod.getHiddenMethod(a,"v");
	}
}
