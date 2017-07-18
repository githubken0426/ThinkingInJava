package designPattern.headfirst.chapter_07Adapter.amExample;

import designPattern.headfirst.chapter_07Adapter.amExample.adapter.TurkeyAdapter;
import designPattern.headfirst.chapter_07Adapter.amExample.duck.Duck;
import designPattern.headfirst.chapter_07Adapter.amExample.duck.MallardDuck;
import designPattern.headfirst.chapter_07Adapter.amExample.duck.Turkey;
import designPattern.headfirst.chapter_07Adapter.amExample.duck.WildTurkey;

public class DuckTestDrive {
	public static void main(String[] args) {
		Turkey turkey=new WildTurkey();
		Duck adapterDuck=new TurkeyAdapter(turkey);
		adapterDuck.quack();
		adapterDuck.fly();
		
		adapterDuck=new MallardDuck();
		adapterDuck.quack();
		adapterDuck.fly();
	}
}
