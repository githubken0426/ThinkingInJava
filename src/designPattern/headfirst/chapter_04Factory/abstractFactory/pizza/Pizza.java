package designPattern.headfirst.chapter_04Factory.abstractFactory.pizza;

import designPattern.headfirst.chapter_04Factory.abstractFactory.ingredent.Cheese;
import designPattern.headfirst.chapter_04Factory.abstractFactory.ingredent.Dough;
import designPattern.headfirst.chapter_04Factory.abstractFactory.ingredent.Sauce;

public abstract class Pizza {
	public abstract void prepare();
	
	public String name;
	public Dough dough;
	public Cheese cheese;
	public Sauce sauce;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void bake(){
		System.out.println("烘烤中...");
	}
	public void cut(){
		System.out.println("切块！");
	}
	public void box(){
		System.out.println("装箱！");
	}
}
