package cn._protected;

import cn._protected._01.Fatcher;
import cn._protected._02.Son;

public class Test {
	public static void main(String[] args) {
		Fatcher son=new Son();
		//compile error
		//son.id;
	}
}
