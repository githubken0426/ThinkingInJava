package th.part_16_Array._04_multidimensional;

import java.util.Arrays;
import java.util.Random;

/**
 * �ֲ�����
 * @author Administrator
 * 2015��11��2��
 */
public class ReggedArray {
	public static void main(String[] args) {
		Random random=new Random(47);
		int [][][] a=new int[random.nextInt(7)][][];
		for(int i=0;i<a.length;i++){
			a[i]=new int[random.nextInt(5)][];
			for(int j=0;j<a[i].length;j++){
				a[i][j]=new int[random.nextInt(5)];
			}
		}
		System.out.println(Arrays.deepToString(a));
	}
}
