package th.part_16_Array._07_Arrays._05BinarySearch;

import java.util.Arrays;

import TIJ4_code.net.mindview.util.ConvertTo;
import TIJ4_code.net.mindview.util.Generated;
import TIJ4_code.net.mindview.util.Generator;
import TIJ4_code.net.mindview.util.RandomGenerator;
import TIJ4_code.net.mindview.util.RandomGenerator.Integer;

/**
 * 在已排序的数组中查找
 * 如果数组已经排好序了，可以使用Arrays.binarySearch()进行查找
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
