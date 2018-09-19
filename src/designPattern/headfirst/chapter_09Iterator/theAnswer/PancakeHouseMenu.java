package designPattern.headfirst.chapter_09Iterator.theAnswer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import designPattern.headfirst.chapter_09Iterator.anExample.MenuItem;

public class PancakeHouseMenu {
	static List<MenuItem> menuItems = new ArrayList<MenuItem>();
	static {
		for (int i = 0; i < 10; i++) {
			MenuItem item = new MenuItem("CakeHose A" + i, "M" + i, true, 2 * i);
			menuItems.add(item);
		}
	}

	public Iterator<MenuItem> createIterator() {
		return new PancakeHouseMenuIterator(menuItems);
	}
}
