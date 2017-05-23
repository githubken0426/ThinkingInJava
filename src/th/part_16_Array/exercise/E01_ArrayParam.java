package th.part_16_Array.exercise;

import th.part_16_Array._01.BeryliumSphere;
/**
 * Á·Ï°1
 * @author Administrator
 * 2015Äê11ÔÂ2ÈÕ
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
