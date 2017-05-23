package th.part_16_Array.exercise;

import java.util.Arrays;

import th.part_16_Array._01.BeryliumSphere;

/**
 * Á·Ï°2
 * @author Administrator
 * 2015Äê11ÔÂ2ÈÕ
 */

public class E02_RunningArray {
	public static BeryliumSphere[] crateArray(int l){
		BeryliumSphere[] b=new BeryliumSphere[l];
		for(int i=0;i<l;i++){
			b[i]=new BeryliumSphere();
		}
		return b;
	}
	
	 public static void main(String[] args) {
		System.out.println(Arrays.toString(crateArray(2)));
	}
}
