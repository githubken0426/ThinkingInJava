package th.part_16_Array.exercise;

import java.util.Arrays;

import th.part_16_Array._01.BeryliumSphere;

/**
 * 练习六
 * 填充一个二维数组
 * @author Administrator
 * 2015年11月6日
 */
public class E06_Filling2DArray {
	public static BeryliumSphere[][] fill(int a,int b){
		BeryliumSphere[][] result=new BeryliumSphere[a][b];
		for(int i=0;i<a;i++){
			for(int j=0;j<b;j++){
				result[i][j]=new BeryliumSphere();
			}
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(fill(3,3)));
	}
}
