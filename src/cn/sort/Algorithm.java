package cn.sort;

import java.util.Arrays;

/**
 * �˴󾭻��������㷨
 * 
 * @author Administrator 2016-4-8 ����09:41:19
 * 
 */
public class Algorithm {
	private static int a[] = new int[] { 8, 12, 13, 3, 4, 7, 9, 10 };

	public static void main(String[] args) {
		System.out.println("=======����ǰ==========");
		System.out.println(Arrays.toString(a));
		insertSort();
		// shellSort();
		// bubbleSort();
		// QuickSort.quickSort(a, 0, a.length-1);
		System.out.println();
		System.out.println("=======�����==========");
		System.out.println(Arrays.toString(a));
	}

	/**
	 * �������� һ��ð������ �㷨˼�� ԭ�����ٽ��������������бȽ�,���մ�С������ߴӴ�С��˳����н���,����һ�˹�ȥ��,
	 * ������С�����ֱ������������һλ,Ȼ���ٴ�ͷ��ʼ���������ȽϽ���,ֱ�������ڶ�λʱ������
	 */
	public static void bubbleSort() {
		System.out.println();
		System.out.println("�����1:");
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
		System.out.println("�����2:");
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
	 * �������� ������������ �㷨˼�� ͨ��һ������Ҫ��������ݷָ�ɶ����������֣� ����һ���ֵ��������ݶ�������һ���ֵ��������ݶ�ҪС��
	 * Ȼ���ٰ��˷����������������ݷֱ���п������� ����������̿��Եݹ���У��Դ˴ﵽ�������ݱ���������У�
	 * 
	 */
	static class QuickSort {

		public static int getMiddle(int[] list, int low, int high) {
			int temp = list[low];// �����һλ��Ϊ����
			while (low < high) {
				while (low < high && list[high] >= temp) {
					high--;
				}
				list[low] = list[high];// ������С���Ƶ��Ͷ�
				while (low < high && list[low] <= temp) {
					low++;
				}
				list[high] = list[low];// ���������Ƶ��߶�
			}
			list[low] = temp;// �����¼��β
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
	 * �������� 
	 * һ��ֱ�Ӳ������� 
	 * �㷨˼�룺 
	 * ��һ��������ļ�¼������ؼ���ֵ�Ĵ�С����ǰ���Ѿ�������ļ����ʵ�λ���ϣ� ֱ��ȫ��������Ϊֹ
	 * 
	 */
	public static void insertSort() {
		// ����һ
		for (int i = 1; i < a.length; i++) {
			int temp = a[i];
			int j = i - 1;
			for (; j >= 0 && temp < a[j]; j--) {
				// ������temp��ֵ�������һ����λ
				a[j + 1] = a[j];
			}
			a[j + 1] = temp;
		}
	}
	
	public static void insertSort2() {
		// ������
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
		// ������
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
	 * �������� ����ϣ��������С��������
	 */
	public static void shellSort() {

	}

	/**
	 * ѡ������ һ����ѡ������
	 */

	/**
	 * ѡ������ ����������
	 */

	/**
	 * �鲢����
	 */

	/**
	 * ��������
	 */
}
