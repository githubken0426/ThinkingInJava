package th.part_15_Generic.chapter_07_Erased._00;

import java.util.ArrayList;

/**
 * ²Á³ı
 * @author Administrator
 * 2015Äê10ÔÂ8ÈÕ
 */
public class ErasedTypeMain {
	public static void main(String[] args) {
		Class<?> c1=new ArrayList<String>().getClass();
		Class<?> c2=new ArrayList<Integer>().getClass();
		System.out.println("c1==c2:"+(c1==c2));
		System.out.println("c1.equals(c2):"+c1.equals(c2));
	}
}
