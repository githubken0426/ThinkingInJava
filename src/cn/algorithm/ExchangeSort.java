package cn.algorithm;

public class ExchangeSort {

	static class Bubble {
		/**
		 * 交换排序 一： 冒泡排序 算法思想 原理是临近的数字两两进行比较,按照从小到大或者从大到小的顺序进行交换,这样一趟过去后,
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
		 * 设置标志性变量pos,用于记录每趟排序中最后一次进行交换的位置。 由于pos位置之后的记录均已交换到位,故在进行下一趟排序时只要扫描到pos位置即可
		 * 
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
	 * 第一步：首先我们从数组的left位置取出该数（20）作为基准（base）参照物。
	 * 第二步：从数组的right位置向前找，一直找到比（base）小的数，
                如果找到，将此数赋给left位置（也就是将10赋给20），
                此时数组为：10，40，50，10，60，
            left和right指针分别为前后的10。
     * 第三步：从数组的left位置向后找，一直找到比（base）大的数，
                 如果找到，将此数赋给right的位置（也就是40赋给10），
                 此时数组为：10，40，50，40，60，
             left和right指针分别为前后的40。
	 * 第四步：重复“第二,第三“步骤，直到left和right指针重合，
             最后将（base）插入到40的位置，
             此时数组值为： 10，20，50，40，60，至此完成一次排序。
	 * 第五步：此时20已经潜入到数组的内部，20的左侧一组数都比20小，20的右侧作为一组数都比20大，
            以20为切入点对左右两边数按照"第一，第二，第三，第四"步骤进行，最终快排大功告成。
	 * 交换排序 二：要求时间最快时。 
	 * 选择第一个数为a，小于a的数放在左边，大于a的数放在右边,递归的将a左边和右边的数都按照第一步进行，直到不能递归.
	 * 
	 * 快速排序 算法思想 通过一趟排序将要排序的数据分割成独立的两部分, 其中一部分的所有数据都比另外一部分的所有数据都要小,
	 * 然后再按此方法对这两部分数据分别进行快速排序, 整个排序过程可以递归进行，以此达到整个数据变成有序序列；
	 */
	public static class QuickSort {
		public static void quickSort(int[] a, int low, int high) {
			int start = low;
			int end = high;
			int key = a[low];
			while (end > start) {
				// 从后往前比较
				while (end > start && a[end] >= key) // 如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
					end--;
				if (a[end] <= key) {
					int temp = a[end];
					a[end] = a[start];
					a[start] = temp;
				}
				// 从前往后比较
				while (end > start && a[start] <= key)// 如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
					start++;
				if (a[start] >= key) {
					int temp = a[start];
					a[start] = a[end];
					a[end] = temp;
				}
				// 此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
			}
			// 递归
			if (start > low)
				quickSort(a, low, start - 1);// 左边序列。第一个索引位置到关键值索引-1
			if (end < high)
				quickSort(a, end + 1, high);// 右边序列。从关键值索引+1到最后一个
		}

		public static int getMiddle(int[] array, int low, int high) {
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

		public static void quickSort0(int[] a, int low, int high) {
			if (low > high)
				return;
			int middle = getMiddle(a, low, high);
			quickSort0(a, low, middle - 1);
			quickSort0(a, middle + 1, high);
		}

	}

}
