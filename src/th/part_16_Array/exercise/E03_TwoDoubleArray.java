package th.part_16_Array.exercise;

import java.util.Locale;

/**
 * 练习三
 * @author Administrator
 * 2015年11月2日
 */
public class E03_TwoDoubleArray {
	public static double[][] createDoubleDarray(int a,int b,double valStart,double valEnd){
		double d[][] = new double[a][b];
		double increment=(valStart-valEnd)/(a*b);
		double val=valStart;
		
		for(int i=0;i<d.length;i++){
			for(int j=0;j<d[i].length;j++){
				d[i][j]=val;
				val+=increment;
			}
		}
		return d;
	}
	
	public static void print(double d[][]){
		for(int i=0;i<d.length;i++){
			for(int j=0;j<d[i].length;j++){
				System.out.printf(Locale.US,"%.2f",d[i][j]);
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		print(createDoubleDarray(4,6,47.0,99.0));
	}
}
