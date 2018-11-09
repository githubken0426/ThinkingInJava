package cn.algorithm;

public class ExchangeSort {
	static class Bubble{
		/**
		 * 交换排序 一：
		 * 冒泡排序 
		 * 算法思想 原理是临近的数字两两进行比较,按照从小到大或者从大到小的顺序进行交换,这样一趟过去后,
		 * 最大或最小的数字被交换到了最后一位,然后再从头开始进行两两比较交换,直到倒数第二位时结束；
		 */
		public static int[] bubbleSort(int[] array) {
			int temp = 0;
			for (int i = array.length - 1; i > 0; i--) {
				for (int j = 0; j < i; j++) {
					if (array[i] < array[j]) {
						temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
				}
			}
			return array;
		}
		
		/**
		 * 设置标志性变量pos,用于记录每趟排序中最后一次进行交换的位置。
		 * 由于pos位置之后的记录均已交换到位,故在进行下一趟排序时只要扫描到pos位置即可
		 * @param array
		 * @param n
		 */
		public static Integer[] bubbleSort_2(Integer array[]) {
			int i = array.length - 1; // 初始时,最后位置保持不变
			while (i > 0) {
				int pos = 0; // 每趟开始时,无记录交换
				for (int j = 0; j < i; j++)
					if (array[j] > array[j + 1]) {
						pos = j; // 记录交换的位置
						int tmp = array[j];
						array[j] = array[j + 1];
						array[j + 1] = tmp;
					}
				i = pos; // 为下一趟排序作准备
			}
			return array;
		}
	}

	/**
	 * 交换排序 二：
	 * 要求时间最快时。选择第一个数为p，小于p的数放在左边，大于p的数放在右边。递归的将p左边和右边的数都按照第一步进行，直到不能递归
	 * 快速排序 
	 * 算法思想 通过一趟排序将要排序的数据分割成独立的两部分， 其中一部分的所有数据都比另外一部分的所有数据都要小，
	 * 然后再按此方法对这两部分数据分别进行快速排序， 整个排序过程可以递归进行，以此达到整个数据变成有序序列；
	 */
	static class QuickSort {
		public static int getMiddle(Integer[] array, int low, int high) {
			int temp = array[low];// 数组第一位作为中轴
			while (low < high) {
				while (low < high && array[high] >= temp) {
					high--;
				}
				array[low] = array[high];// 比中轴小的移到低端
				while (low < high && array[low] <= temp) {
					low++;
				}
				array[high] = array[low];// 比中轴大的移到高端
			}
			array[low] = temp;// 中轴记录到尾
			return low;
		}

		public static void quickSort(Integer[] a, int low, int high) {
			if (low > high)
				return;
			int middle = getMiddle(a, low, high);
			quickSort(a, low, middle - 1);
			quickSort(a, middle + 1, high);
		}
		
		/**
		 * 第二种写法
		 * @param a
		 * @param low
		 * @param high
		 * @throws 
		 * @date 2018年4月2日 上午8:41:36
		 */
		public static void quickSort2(Integer[] a, int low, int high) {
			if (low >= high)
				return;
			int baseNum = a[low];// 选基准值
			int midNum;// 记录中间值
			int i=low;
			int j=high;
			do {
				while ((a[i] < baseNum) && i < high) {
					i++;
				}
				while ((a[j] > baseNum) && j > low) {
					j--;
				}
				if (i <= j) {
					midNum = a[i];
					a[i] = a[j];
					a[j] = midNum;
					i++;
					j--;
				}
			} while (i <= j);
			
			if (low < j) {
				quickSort2(a, low, j);
			}
			if (high > i) {
				quickSort2(a, i, high);
			}
		}
	}

}
