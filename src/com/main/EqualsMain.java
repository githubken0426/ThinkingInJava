package com.main;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import com.equals.Students;

public class EqualsMain {

	
	public static void main(String[] args) {
		
		LinkedList<Students> list = new LinkedList<Students>();  
	    Set<Students> set = new HashSet<Students>();
	    
		Students stu1=new Students(23,"����");
		Students stu2=new Students(23,"����");
		list.add(stu1);
		list.add(stu2);
		
		set.add(stu1);
		set.add(stu2);
		
		System.out.println("stu1==stu2:"+(stu1==stu2));
		System.out.println("stu1.equals(stu2):"+stu1.equals(stu2));
		
		System.out.println("list.size():"+list.size());
		System.out.println("set.size():"+set.size());
		/**
		 * &��λ�����
		 * ������߶���int���ͣ���ת����2���ƣ���������
		 * ������int��boolean�Ƚ�
		 * &���߱��ʽ��Ҫ�Ƚϣ�if(10!=10&&10/0==0)
		 * &&�����һ�����ʽ����������10!=10��������һ�����ʽ�����Ƚ���if(10!=10&&10/0==0)
		 */
		System.out.println("1&1:"+(2&1));
		System.out.println("1&-1:"+(1&-1));
		System.out.println("1&3:"+(3&2));
	}
}
