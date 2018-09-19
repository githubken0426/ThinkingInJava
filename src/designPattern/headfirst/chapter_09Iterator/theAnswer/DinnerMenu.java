package designPattern.headfirst.chapter_09Iterator.theAnswer;

import java.util.Iterator;

import designPattern.headfirst.chapter_09Iterator.anExample.MenuItem;

public class DinnerMenu {
	static MenuItem[] menuItems=new MenuItem[10];
	static {
		for(int i=0;i<10;i++) {
			MenuItem item=new MenuItem("Dinner A"+i,"M"+i,true,2*i);
			menuItems[i]=item;
		}
	}
	
	public Iterator<MenuItem> createIterator() {
		return new DinnerMenuIterator(menuItems);
	}

}