package designPattern.headfirst.chapter_09Iterator.theAnswer;

import java.util.Iterator;

import designPattern.headfirst.chapter_09Iterator.anExample.MenuItem;

public class DinnerMenu {
	static final int MAX_ITEMS = 6;
	int numberOfItems;
	MenuItem[] menuItems;

	public Iterator<MenuItem> createIterator() {
		return new DinnerMenuIterator(menuItems);
	}

}