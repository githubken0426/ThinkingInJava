package th.part_16_Array._07_Arrays._03;

import java.util.Arrays;


import TIJ4_code.net.mindview.util.Generated;

public class Reverse {
	public static void main(String[] args) {
		CompType t[]=Generated.array(new CompType[12], CompType.generator());
		System.out.println("before sort:"+Arrays.toString(t));
		Arrays.sort(t);
		System.out.println("after sort:"+Arrays.toString(t));
	}
}
