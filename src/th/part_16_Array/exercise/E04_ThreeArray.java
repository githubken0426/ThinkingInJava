package th.part_16_Array.exercise;

import java.util.Locale;

/**
 * 练习四
 * @author Administrator
 * 2015年11月3日
 */
public class E04_ThreeArray {
	public static double[][][] createThreeAyyay(double valStart,double valEnd,int a,int b,int c){
		double[][][] result=new double[a][b][c];
		double increment=(valStart-valEnd)/(a*b*c);
		double val=valStart;
		for(int i=0;i<result.length;i++){
			for(int j=0;j<result[i].length;j++){
				for(int l=0;l<result[i][j].length;l++){
					result[i][j][l]=val;
					val=increment;
				}
			}
		}
		return result;
	}
	
	public static void print(double d[][][]){
		for(int i=0;i<d.length;i++){
			for(int j=0;j<d[i].length;j++){
				for(int l=0;l<d[i][j].length;l++){
					System.out.printf(Locale.US,"%.2f",d[i][j][l]);
					System.out.println();
				}
			}
		}
	}
	public static void main(String[] args) {
		print(createThreeAyyay(47.0,99.0,4,3,3));
	}
}
