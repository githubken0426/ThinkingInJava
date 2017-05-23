package th.part_15_Generic.chapter_07_Erased._00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * �����ڲ���
 * @author Administrator
 * 2015��10��8��
 */
public class ErasedClasses {
	public static class Frob{}
	public static class Fnorkle{}
	public static class Quark<Q>{}
	public static class Particle<POSITION,MOMENTUM>{}
	
	/**
	 * ��������Ϣ
	 * @author Administrator
	 * 2015��10��8��
	 */
	public static class LostInfo{
		public static void main(String[] args) {
			List<Frob> list=new ArrayList<Frob>();
			Map<Frob,Fnorkle> map=new HashMap<Frob,Fnorkle>();
			Quark<Fnorkle> quark=new Quark<Fnorkle>();
			Particle<Long,Double> particle=new Particle<Long,Double>();
			/**
			 * ��ȡ��ֻ��-->����ռλ���ı�ʾ��
			 * �����ڲ����޷���ȡ�κι��ڷ��Ͳ������͵���Ϣ
			 */
			System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
			System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
			System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
			System.out.println(Arrays.toString(particle.getClass().getTypeParameters()));
		}
	}
}
