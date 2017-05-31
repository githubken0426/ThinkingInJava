package th.part_16_Array._07_Arrays._05BinarySearch;

/**
 * 二分查找算法 
 * 又称折半查找，优点是比较次数少，查找速度快，平均性能好； 
 * 其缺点是要求待查表为有序表，且插入删除困难。 
 * 前提：数组必须是有序的。
 * 
 * @author ken 2017-5-31 下午03:39:03
 */
public class BinarySearch {
	/**
	 * 递归
	 * @param array
	 * @param key
	 * @param left
	 * @param right
	 * @return
	 * 2017-5-31 下午03:42:19
	 */
	public static int binarySearch(Integer array[], int key, int left, int right) {
		 // 防止用(left+right)/2时left+high溢出
		int center = left + (right - left) / 2;
		if (array[center] == key) {
			System.out.println("找到了");
			return center;
		} 
		if (array[center] < key) {
			return binarySearch(array, key, center + 1, right);
		} 
		if (array[center] > key) {
			return binarySearch(array, key, left, center - 1);
		}
		return -1;
	}

	/**
	 * 非递归
	 * @param array
	 * @param key
	 * @return
	 * 2017-5-31 下午03:42:38
	 */
	public static int binarySearch1(Integer array[], int key) {
		int left = 0, right = array.length - 1;
		int mid = -1;
		while (left <= right) {
			mid = left + ((right - left) >> 1);
			if (key == array[mid]) {
				return mid;
			} else if (key < array[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
}
