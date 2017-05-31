package cn._protected._01;

import cn._protected._02.Son;

public class Test {
	public static void main(String[] args) {
		Fatcher son=new Son();
		System.out.println(son.id);
		System.out.println(son.getId(100));
	}
}
