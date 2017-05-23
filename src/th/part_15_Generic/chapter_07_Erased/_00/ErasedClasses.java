package th.part_15_Generic.chapter_07_Erased._00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 共享内部类
 * @author Administrator
 * 2015年10月8日
 */
public class ErasedClasses {
	public static class Frob{}
	public static class Fnorkle{}
	public static class Quark<Q>{}
	public static class Particle<POSITION,MOMENTUM>{}
	
	/**
	 * 擦除的信息
	 * @author Administrator
	 * 2015年10月8日
	 */
	public static class LostInfo{
		public static void main(String[] args) {
			List<Frob> list=new ArrayList<Frob>();
			Map<Frob,Fnorkle> map=new HashMap<Frob,Fnorkle>();
			Quark<Fnorkle> quark=new Quark<Fnorkle>();
			Particle<Long,Double> particle=new Particle<Long,Double>();
			/**
			 * 获取的只是-->参数占位符的标示符
			 * 泛型内部，无法获取任何关于泛型参数类型的信息
			 */
			System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
			System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
			System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
			System.out.println(Arrays.toString(particle.getClass().getTypeParameters()));
		}
	}
}
