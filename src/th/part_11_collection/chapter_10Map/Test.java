package th.part_11_collection.chapter_10Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 测试统计数字重复出现次数
 * 
 * @author ken
 * 2016-12-28 下午02:53:39
 */
public class Test {
	private static Random random=new Random(47);
	
	public static void main(String[] args) {
		Map<Object,Integer> map=new HashMap<Object,Integer>();
		for(int i=0;i<200;i++){
			Integer temp=map.get(random.nextInt(10));
			map.put(random.nextInt(10), temp==null?1:temp+1);
		}
		System.out.println(map);
	}
}
