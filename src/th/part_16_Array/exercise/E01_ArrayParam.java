package th.part_16_Array.exercise;

import th.part_16_Array._01.BeryliumSphere;
/**
 * ��ϰ1
 * @author Administrator
 * 2015��11��2��
 */
public class E01_ArrayParam {
	public static void hide(BeryliumSphere [] phere){
		System.out.println("Hiding:"+phere.length);
	}
	public static void main(String[] args) {
		hide(new BeryliumSphere[]{new BeryliumSphere(),new BeryliumSphere()});
		BeryliumSphere[] d={new BeryliumSphere(),new BeryliumSphere()};
		hide(d);
		//compile error
//		hide({new BerylliumSphere(),new BerylliumSphere()});
		
	}
}
