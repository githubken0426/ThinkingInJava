package com.main;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import com.equals.Students;

public class EqualsMain {

	
	public static void main(String[] args) {
		
		LinkedList<Students> list = new LinkedList<Students>();  
	    Set<Students> set = new HashSet<Students>();
	    
		Students stu1=new Students(23,"张三");
		Students stu2=new Students(23,"张三");
		list.add(stu1);
		list.add(stu2);
		
		set.add(stu1);
		set.add(stu2);
		
		System.out.println("stu1==stu2:"+(stu1==stu2));
		System.out.println("stu1.equals(stu2):"+stu1.equals(stu2));
		
		System.out.println("list.size():"+list.size());
		System.out.println("set.size():"+set.size());
		/**
		 * &按位运算符
		 * 如果两者都是int类型，则转换成2进制，进行运算
		 * 常用于int和boolean比较
		 * &两者表达式都要比较，if(10!=10&&10/0==0)
		 * &&如果第一个表达式满足条件（10!=10），则下一个表达式比作比较入if(10!=10&&10/0==0)
		 */
		System.out.println("1&1:"+(2&1));
		System.out.println("1&-1:"+(1&-1));
		System.out.println("1&3:"+(3&2));
	}
}
