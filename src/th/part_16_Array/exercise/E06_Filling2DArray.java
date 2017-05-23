package th.part_16_Array.exercise;

import java.util.Arrays;

import th.part_16_Array._01.BerylliumSphere;

/**
 * 练习六
 * 填充一个二维数组
 * @author Administrator
 * 2015年11月6日
 */
public class E06_Filling2DArray {
	public static BerylliumSphere[][] fill(int a,int b){
		BerylliumSphere[][] result=new BerylliumSphere[a][b];
		for(int i=0;i<a;i++){
			for(int j=0;j<b;j++){
				result[i][j]=new BerylliumSphere();
			}
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(fill(3,3)));
	}
}
