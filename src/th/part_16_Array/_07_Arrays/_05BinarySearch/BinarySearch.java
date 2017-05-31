package th.part_16_Array._07_Arrays._05BinarySearch;

import java.util.Arrays;


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
		Integer location=array[center];
		if (location == key) {
			System.out.println("找到了");
			return center;
		} 
		if (location < key) {
			return binarySearch(array, key, center + 1, right);
		} 
		if (location > key) {
			return binarySearch(array, key, left, center - 1);
		}
		return -1;
	}

	/**
	 * Arrays源码
	 * 
	 * java移位运算符:详见com.displacement.Displacement
	 * 
	 * @param a
	 * @param fromIndex
	 * @param toIndex
	 * @param key
	 * @return
	 * 2017-5-31 下午04:18:38
	 */
	@SuppressWarnings("unchecked")
	public static int binarySearch(Object[] a, int fromIndex, int toIndex,
			Object key) {
		int low = fromIndex;
		int high = toIndex - 1;

		while (low <= high) {
			int mid = (low + high) >>> 1;
			Comparable<Object> midVal = (Comparable<Object>) a[mid];
			int cmp = midVal.compareTo(key);
			if (cmp < 0)
				low = mid + 1;
			else if (cmp > 0)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); // key not found.
	}
	
	public static void main(String[] args) {
		String str[]=new String[]{"b","c","a","d","h","e","f"};
		Arrays.sort(str);
		while(true){
			String r="f";
			int location=BinarySearch.binarySearch(str,0,str.length, r);
			if(location>=0){
				System.out.println("location of "+r+" is "+location+",a["+location+"]="+str[location]);
				break;
			}else{
				System.out.println("没有找到");
				break;
			}
		}
	}
}
