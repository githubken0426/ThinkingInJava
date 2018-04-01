package cn.algorithm;

import java.util.Arrays;

/**
 * 八大经基本排序算法
 * 
 * @author Administrator 2016-4-8 上午09:41:19
 * 
 */
public class Algorithm {
	private static int a[] = new int[] { 8, 12, 13, 3, 4, 7, 9, 10 };
	public static void main(String[] args) {
		System.out.println("=======排序前==========");
		System.out.println(Arrays.toString(a));
		insertSort();
		// shellSort();
		// bubbleSort();
		// QuickSort.quickSort(a, 0, a.length-1);
		System.out.println();
		System.out.println("=======排序后==========");
		System.out.println(Arrays.toString(a));
	}

	/**
	 * 交换排序 一：冒泡排序 算法思想 原理是临近的数字两两进行比较,按照从小到大或者从大到小的顺序进行交换,这样一趟过去后,
	 * 最大或最小的数字被交换到了最后一位,然后再从头开始进行两两比较交换,直到倒数第二位时结束；
	 */
	public static void bubbleSort() {
		System.out.println("排序后1:");
		int temp = 0;
		for (int i = 0; i < a.length - 1; i++) {
			for (int n = 0; n < a.length - i - 1; n++) {
				if (a[n] > a[n + 1]) {
					temp = a[n];
					a[n] = a[n + 1];
					a[n + 1] = temp;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		
		System.out.println();
		System.out.println("排序后2:");
		for (int i = a.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (a[i] < a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
	}

	/**
	 * 交换排序 二：快速排序 算法思想 通过一趟排序将要排序的数据分割成独立的两部分， 其中一部分的所有数据都比另外一部分的所有数据都要小，
	 * 然后再按此方法对这两部分数据分别进行快速排序， 整个排序过程可以递归进行，以此达到整个数据变成有序序列；
	 * 
	 */
	static class QuickSort {
		public static int getMiddle(int[] list, int low, int high) {
			int temp = list[low];// 数组第一位作为中轴
			while (low < high) {
				while (low < high && list[high] >= temp) {
					high--;
				}
				list[low] = list[high];// 比中轴小的移到低端
				while (low < high && list[low] <= temp) {
					low++;
				}
				list[high] = list[low];// 比中轴大的移到高端
			}
			list[low] = temp;// 中轴记录到尾
			return low;
		}

		public static void quickSort(int[] a, int low, int high) {
			if (low < high) {
				int middle = getMiddle(a, low, high);
				quickSort(a, low, middle - 1);
				quickSort(a, middle + 1, high);
			}
		}
	}

	/**
	 * 插入排序 一：直接插入排序 算法思想： 将一个待排序的纪录，按其关键码值的大小插入前面已经排序的文件中适当位置上， 直到全部插入完为止
	 * 
	 */
	public static void insertSort() {
		// 方法一
		for (int i = 1; i < a.length; i++) {
			int temp = a[i];
			int j = i - 1;
			for (; j >= 0 && temp < a[j]; j--) {
				// 将大于temp的值整体后移一个单位
				a[j + 1] = a[j];
			}
			a[j + 1] = temp;
		}
	}

	public static void insertSort2() {
		// 方法二
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j] < a[j - 1]) {
					int temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				}
			}
		}
	}

	public static void insertSort3() {
		// 方法三
		int tmp;
		int j;
		for (int i = 1; i < a.length; i++) {
			tmp = a[i];
			for (j = i - 1; j >= 0 && a[j] > tmp; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = tmp;
		}
	}

	/**
	 * 插入排序 二：希尔排序（最小增量排序）
	 */
	public static void shellSort() {

	}

	/**
	 * 选择排序 一：简单选择排序
	 */

	/**
	 * 选择排序 二：堆排序
	 */

	/**
	 * 归并排序
	 */

	/**
	 * 基数排序
	 */
}
