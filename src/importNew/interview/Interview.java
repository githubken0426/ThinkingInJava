package importNew.interview;

import java.math.BigDecimal;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 面试题
 * 
 * @author ken 2017-5-12 下午01:35:39
 */
class B extends Interview {}
class C extends B {}
public class Interview {
	/**
	 * question 1:父类能转换成子类吗？
	 * 
	 * 2017-5-12 下午01:48:57
	 */
	public static void translate() {
		Interview in = new B();
		System.out.println(in);
		// 父类无法转换为子类
		// C c=(C) new B();
		// System.out.println(c);
	}

	/**
	 * question 2:3*0.1 == 0.3结果？ 建议使用BigDecimal
	 * 
	 * 2017-5-12 下午01:50:54
	 */
	public static void test() {
		System.out.println("3*0.1:" + 3 * 0.1);
		System.out.println("3*0.1==0.3:" + (3 * 0.1 == 0.3));
		System.out.println(new BigDecimal(123456789.02).toString());
		System.out.println(new BigDecimal("123456789.02").toString());
	}

	public static void main(String[] args) {
		test();
		Queue<Integer> q = new PriorityQueue<Integer>();
	}
}
