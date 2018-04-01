package cn.algorithm;

import java.util.Arrays;

public class Test {
	private static int a[]=new int[] { 8, 12, 13, 3, 4, 7, 9, 10 };
	public static void main(String[] args) {
		System.out.println("Before sort");
		System.out.println(Arrays.toString(a));
//		bubbleSort();
		QuickSort.quickSort(a,0,a.length-1);
		
		System.out.println("After sort");
		System.out.println(Arrays.toString(a));
	}
	
	private static void bubbleSort(){
		for(int i=0;i<a.length-1;i++){
			for(int j=0;j<a.length-1-i;j++){
				int temp=0;
				if(a[j]>a[j+1]){
					temp = a[j];
					a[j]= a[j+1];
					a[j+1]=temp;
				}
			}
		}
	}
	
	static class QuickSort{
		public static int getMiddle(int [] array,int low,int high){
			int temp=array[low];
			while(low<high){
				while(low<high && array[high]>=temp){
					high--;
				}
				array[low] = array[high];
				while(low<high && array[low]<=temp){
					low++;
				}
				array[high] = array[low];
			}
			array[low]=temp;
			return low;
		}
		public static void quickSort(int [] array,int low,int high){
			if(low<high){
				int temp=getMiddle(array,low,high);
				quickSort(array,low,temp-1);
				quickSort(array,temp+1,high);
			}
		}
	}
}
