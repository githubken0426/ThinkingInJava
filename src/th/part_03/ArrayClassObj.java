package th.part_03;

import java.util.*;

import th.part_03.bean.Students;

public class ArrayClassObj {
	
	static Random ran=new Random();
	static int pRand (int mod){
		return Math.abs(ran.nextInt())%mod+1;
	}
	
	public static void main(String[] args) {
		Integer [] a=new Integer[pRand(20)];
		System.out.println("length:"+a.length);
		
		for (int i = 0; i < a.length; i++) {
			a[i]=new Integer(pRand(20));
			System.out.println("a["+i+"]:"+a[i]);
		}
		Students stu[]=new Students[3];
		for (int i = 0; i < stu.length; i++) {
			stu[i]=new Students(i+20,"Àî"+i);
			System.out.println(stu[i].getAge()+stu[i].getName());
		}
		
	}
}
