package th.part_16_Array._01;

import java.util.Arrays;

public class ContainerComparison {
	public static void main(String[] args) {
		BerylliumSphere sphere[]=new BerylliumSphere[10];
		for(int i=0;i<5;i++){
			sphere[i]=new BerylliumSphere();
		}
		System.out.println(Arrays.toString(sphere));
		System.out.println(sphere[4]);
		BerylliumSphere spherew[]=new BerylliumSphere[]{};
		System.out.println(spherew.length);
		spherew=sphere;
		System.out.println(Arrays.toString(spherew));
	}
	
}
