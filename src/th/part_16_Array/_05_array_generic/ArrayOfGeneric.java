package th.part_16_Array._05_array_generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import th.part_16_Array._01.BeryliumSphere;

public class ArrayOfGeneric {
	public static void main(String[] args) {
		List<String>[]ls;
		List[] la=new List[20];
		ls=(List<String>[])la;
		ls[0]=new ArrayList<String>();
//		ls[1]=new ArrayList<Integer>();//±‡“Î¥ÌŒÛ
		Object[] obj=ls;
		obj[1]=new ArrayList<Integer>();
		List<BeryliumSphere> []sphere=new List[10];
		for(int i =0;i<sphere.length;i++){
			sphere[i]=new ArrayList<BeryliumSphere>();
		}
		System.out.println(Arrays.toString(sphere));
	}
}
