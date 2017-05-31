package th.part_16_Array._07_Arrays._05BinarySearch;

import java.util.Arrays;

import TIJ4_code.net.mindview.util.ConvertTo;
import TIJ4_code.net.mindview.util.Generated;
import TIJ4_code.net.mindview.util.RandomGenerator;
import TIJ4_code.net.mindview.util.RandomGenerator.Integer;

/**
 * 在已排序的数组中查找
 * 如果数组已经排好序了，可以使用Arrays.binarySearch()进行查找,
 * 如找到目标返回值>=0，否则产生负值(即下面"插入点")。
 * 负值表示若保持数组的排序状态此"目标元素"应该插入的位置。
 * 插入位置计算方法：-(插入点)-1
 * 如果数组中所有元素都小于目标元素，则"插入点"就是数组的长度(length)
 * 
 * 
 * 
 * @author ken
 * 2017-5-31 下午02:52:22
 */
public class SearchingArrays {
	public static void main(String[] args) {
		Integer gen=new RandomGenerator.Integer(1000);
		int a[]=ConvertTo.primitive(Generated.array(new java.lang.Integer[25], gen));
		Arrays.sort(a);
		System.out.println("sorted:"+Arrays.toString(a));
		
		while(true){
			int r=gen.next();
			int location=Arrays.binarySearch(a, r);
			if(location>=0){
				System.out.println("location of "+r+" is "+location+",a["+location+"]="+a[location]);
				break;
			}
		}
	}
}
