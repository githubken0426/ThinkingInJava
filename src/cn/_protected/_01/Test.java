package cn._protected._01;

import cn._protected._02.Son;

public class Test {
	public static void main(String[] args) {
		Fatcher son=new Son();
		/**
		 * 受保护属性
		 * 同一包中编译正常
		 */
		System.out.println(son.id);
		System.out.println(son.getId(100));
	}
}
