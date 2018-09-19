package designPattern.headfirst.chapter_09Iterator.theAnswer;

import java.util.Iterator;
import java.util.List;

import designPattern.headfirst.chapter_09Iterator.anExample.MenuItem;

public class PancakeHouseMenuIterator implements Iterator<MenuItem> {
	List<MenuItem> menuItems;
	int cursor = 0;

	public PancakeHouseMenuIterator(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	@Override
	public boolean hasNext() {
		return menuItems.size() > cursor;
	}

	@Override
	public MenuItem next() {
		MenuItem item = menuItems.get(cursor);
		cursor++;
		return item;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
