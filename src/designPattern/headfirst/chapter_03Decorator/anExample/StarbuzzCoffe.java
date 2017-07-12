package designPattern.headfirst.chapter_03Decorator.anExample;

import designPattern.headfirst.chapter_03Decorator.anExample.beverage.Beverage;
import designPattern.headfirst.chapter_03Decorator.anExample.beverage.Espresso;
import designPattern.headfirst.chapter_03Decorator.anExample.beverage.HouseBlend;
import designPattern.headfirst.chapter_03Decorator.anExample.decorator.Mocha;
import designPattern.headfirst.chapter_03Decorator.anExample.decorator.Soy;
import designPattern.headfirst.chapter_03Decorator.anExample.decorator.Whip;

public class StarbuzzCoffe {
	public static void main(String[] args) {
//		Beverage beverage=new Espresso();
		Beverage beverage2=new HouseBlend();
		beverage2=new Mocha(beverage2);
		beverage2=new Mocha(beverage2);
		beverage2=new Whip(beverage2);
		System.out.println(beverage2.getDescription()+",$"+beverage2.cost()+"\n");
		
		Beverage beverage3=new Espresso();
		beverage3=new Mocha(beverage3);
		beverage3=new Soy(beverage3);
		beverage3=new Whip(beverage3);
		System.out.println(beverage3.getDescription()+",$"+beverage3.cost());
	}
}
