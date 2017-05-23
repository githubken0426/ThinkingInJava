package th.part_11_collection.chapter_10Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 11.10 统计数字重复出现的次数
 * @author Administrator
 * 2016-4-13 下午02:01:56
 *
 */
public class Statistics {
	public static void main(String[] args) {
		Random random=new Random();
		Map<Object,Integer> map=new HashMap<Object,Integer>();
		for(int i=0;i<200;i++){
			int temp=random.nextInt(10);
			Integer val=map.get(temp);
			map.put(temp, val==null?1:val+1);
		}
		System.out.println(map);
	}
}
