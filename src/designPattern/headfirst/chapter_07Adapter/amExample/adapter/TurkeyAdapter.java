package designPattern.headfirst.chapter_07Adapter.amExample.adapter;

import designPattern.headfirst.chapter_07Adapter.amExample.duck.Duck;
import designPattern.headfirst.chapter_07Adapter.amExample.duck.Turkey;
/**
 * 对象适配器模式(使用组合)
 * 类适配器(使用继承，需要多重继承，java不可用)
 * @author ken
 * 
 * @date 2017年7月12日 下午1:32:13
 */
public class TurkeyAdapter implements Duck {
	Turkey turkey;
	public TurkeyAdapter(Turkey turkey){
		this.turkey=turkey;
	}
	
	@Override
	public void quack() {
		turkey.quack();
	}

	@Override
	public void fly() {
		turkey.fly();
	}

}
