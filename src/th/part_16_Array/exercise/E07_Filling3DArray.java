package th.part_16_Array.exercise;

import java.util.Arrays;

import th.part_16_Array._01.BerylliumSphere;

/**
 * 练习七
 * 填充一个三维数组
 * @author Administrator
 * 2015年11月6日
 */
public class E07_Filling3DArray {
	public static BerylliumSphere[][][] fill(int a,int b,int c){
		BerylliumSphere [][][]result=new BerylliumSphere[a][b][c];
		for(int i=0;i<a;i++){
			for(int j=0;j<b;j++){
				for(int g=0;g<c;g++){
					result[i][j][g]=new BerylliumSphere();
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(fill(1,2,3)));
	}
}
