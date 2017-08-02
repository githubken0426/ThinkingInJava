package designPattern.headfirst.chapter_08TemplateMethod.theAnswer;

import java.util.Scanner;

public class CaffeineWithHook extends CaffeineBeverageWithHook {

	@Override
	void brew() {
		System.out.println("Dripping coffee!");
	}

	@Override
	void addCondiments() {
		System.out.println("Adding sugar and milk!");
	}
	@Override
	boolean hook() {
		System.out.println("would like milk and suger with your coffee(Y/N)?");
		Scanner in = new Scanner(System.in);
		if("Y".equalsIgnoreCase(in.next()))
				return true;
		return false;
	}
}
