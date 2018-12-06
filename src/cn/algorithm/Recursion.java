package cn.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 递归调用是一种特殊的嵌套调用，是某个函数调用自己或者是调用其他函数后再次调用自己
 * @ClassName: Recursion 
 * @Description: 
 * @author ken 
 * @date 2018年11月27日 上午11:47:58
 */
public class Recursion {
	static int recursion(int n) {
		if (n == 0)// 递归边界
			return 1;
		return n * recursion(n - 1);// 递归公式
	}

	public static void main(String[] args) {
		System.out.println(recursion(5));
		Map<String,Object> map=new HashMap<String,Object>();
	}
}
