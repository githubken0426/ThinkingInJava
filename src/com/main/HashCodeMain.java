package com.main;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import com.equalsAndhashCode.Students;


public class HashCodeMain {
	public static void main(String[] args) {
		LinkedList<Students> list = new LinkedList<Students>();
		//set无序不重复对象
	    Set<Students> set = new HashSet<Students>();
	    
		Students stu1=new Students(23,"张三");
		Students stu2=new Students(23,"张三");
		list.add(stu1);
		list.add(stu2);
		
		set.add(stu1);
		set.add(stu2);
		System.out.println("tt:"+stu1.getName().compareTo("lisi"));
		System.out.println("stu1==stu2:"+(stu1==stu2));
		System.out.println("stu1.equals(stu2):"+stu1.equals(stu2));
		
		System.out.println("list.size():"+list.size());
		System.out.println("set.size():"+set.size());
	}
}
