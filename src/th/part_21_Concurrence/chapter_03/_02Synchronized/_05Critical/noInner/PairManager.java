package th.part_21_Concurrence.chapter_03._02Synchronized._05Critical.noInner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public abstract class PairManager {
	AtomicInteger atomic=new AtomicInteger();
	protected Pair pair=new Pair();
	private List<Pair> storage=Collections.synchronizedList(new ArrayList<Pair>());
	
	//复制一个原始线程安全的Pair
	public synchronized Pair getPair(){
		return new Pair(pair.getX(),pair.getY());
	}
	//假设一个耗时的操作
	protected void store(Pair p){
		storage.add(p);
		try {
			TimeUnit.MICROSECONDS.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public abstract void increment();
}
