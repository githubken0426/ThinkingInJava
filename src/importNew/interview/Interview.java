package importNew.interview;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;



/**
 * һЩInterview
 * 
 * @author ken 2017-5-12 ����01:35:39
 */
class B extends Interview {}

class C extends B {}

public class Interview {
	/**
	 * question 1:������ת����������
	 * 
	 * 2017-5-12 ����01:48:57
	 */
	public static void translate(){
		Interview in=new B();
		System.out.println(in);
		//�����޷�ת��Ϊ����
//		C c=(C) new B();
//		System.out.println(c);
	}
	/**
	 * question 2:3*0.1 == 0.3�����
	 * ����ʹ��BigDecimal
	 * 
	 * 2017-5-12 ����01:50:54
	 */
	public static void test(){
		System.out.println(3*0.1);
		System.out.println(3*0.1==0.3);
		System.out.println(new BigDecimal(123456789.02).toString());
	    System.out.println(new BigDecimal("123456789.02").toString());
	}
	public static void main(String[] args) {
		test();
		Queue<Integer> q=new PriorityQueue<Integer>();
	}
}

