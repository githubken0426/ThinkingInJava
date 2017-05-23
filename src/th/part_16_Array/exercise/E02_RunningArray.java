package th.part_16_Array.exercise;

import java.util.Arrays;

import th.part_16_Array._01.BerylliumSphere;

/**
 * Á·Ï°2
 * @author Administrator
 * 2015Äê11ÔÂ2ÈÕ
 */

public class E02_RunningArray {
	public static BerylliumSphere[] crateArray(int l){
		BerylliumSphere[] b=new BerylliumSphere[l];
		for(int i=0;i<l;i++){
			b[i]=new BerylliumSphere();
		}
		return b;
	}
	
	 public static void main(String[] args) {
		System.out.println(Arrays.toString(crateArray(2)));
	}
}
