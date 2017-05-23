package th.part_15_Generic.chapter_09_Bounds;

import java.awt.Color;

/**
 * 15.9 边界
 * 
 * @author Administrator
 *
 * @param <T>
 */
public class Colored<T extends HasColor> {
	T item;

	Colored(T item) {
		this.item = item;
	}

	T getItem() {
		return item;
	}

	Color color() {
		return item.getColor();
	}

}

class Dimension {
	public int x, y, z;
}

// compile error:class must first,then interface
// class ColoredDemension<T extends HasColor & Dimension>{}
/**
 * 多个边界
 * 
 * @author Administrator
 *
 * @param <T>
 */
class ColoredDemension<T extends Dimension & HasColor> {
	T item;

	ColoredDemension(T item) {
		this.item = item;
	}

	public T getItem() {
		return item;
	}

	Color getColor() {
		return item.getColor();
	}

	public int getX() {
		return item.x;
	}

	public int getY() {
		return item.y;
	}

	public int getZ() {
		return item.z;
	}
}

interface Weight {
	int weight();
}

/**
 * as with inheritance,you can only one concrete class but multiple interface
 * 
 * @author Administrator
 *
 * @param <T>
 */
class Solid<T extends Dimension & HasColor & Weight> {
	T item;

	Solid(T item) {
		this.item = item;
	}

	public T getItem() {
		return item;
	}

	Color color() {
		return item.getColor();
	}

	public int getX() {
		return item.x;
	}

	public int getY() {
		return item.y;
	}

	public int getZ() {
		return item.z;
	}

	public int weight() {
		return item.weight();
	}
}

class Bounded extends Dimension implements HasColor, Weight {

	@Override
	public int weight() {
		System.out.println("Bounded.weight()");
		return 0;
	}

	@Override
	public Color getColor() {
		System.out.println("Bounded.getColor()");
		return null;
	}
}

