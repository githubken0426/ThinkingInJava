package th.part_16_Array.exercise;

import java.util.Arrays;

import th.part_16_Array._01.BeryliumSphere;

/**
 * ��ϰ��
 * ���һ����ά����
 * @author Administrator
 * 2015��11��6��
 */
public class E07_Filling3DArray {
	public static BeryliumSphere[][][] fill(int a,int b,int c){
		BeryliumSphere [][][]result=new BeryliumSphere[a][b][c];
		for(int i=0;i<a;i++){
			for(int j=0;j<b;j++){
				for(int g=0;g<c;g++){
					result[i][j][g]=new BeryliumSphere();
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(fill(1,2,3)));
	}
}
