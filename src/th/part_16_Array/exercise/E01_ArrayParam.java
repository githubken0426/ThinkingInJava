package th.part_16_Array.exercise;

import th.part_16_Array._01.BerylliumSphere;
/**
 * ��ϰ1
 * @author Administrator
 * 2015��11��2��
 */
public class E01_ArrayParam {
	public static void hide(BerylliumSphere [] phere){
		System.out.println("Hiding:"+phere.length);
	}
	public static void main(String[] args) {
		hide(new BerylliumSphere[]{new BerylliumSphere(),new BerylliumSphere()});
		BerylliumSphere[] d={new BerylliumSphere(),new BerylliumSphere()};
		hide(d);
		//compile error
//		hide({new BerylliumSphere(),new BerylliumSphere()});
		
	}
}
