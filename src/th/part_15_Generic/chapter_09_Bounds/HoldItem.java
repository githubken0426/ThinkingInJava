package th.part_15_Generic.chapter_09_Bounds;

import java.awt.Color;

public class HoldItem<T> {
	T item;
	HoldItem() {}
	HoldItem(T item) {
		this.item = item;
	}

	T getItem() {
		return item;
	}

	public class Color2<T extends HasColor> extends HoldItem<T> {

		Color2(T item) {
			super(item);
		}

		Color color() {
			return item.getColor();
		}
	}

	class ColorDimension2<T extends Dimension & HasColor> extends Color2<T> {
		/**
		 * 内部类的继承必有一个外部类的引用 参照 th.part_10_InnerClass.chapter_09
		 * 
		 * @param hold
		 * @param item
		 */
		ColorDimension2(HoldItem hold, T item) {
			hold.super(item);
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

	class Solid2<T extends Dimension & HasColor & Weight> extends ColorDimension2<T> {

		Solid2(HoldItem hold, T item) {
			hold.super(hold, item);
		}

		int weight() {
			return item.weight();
		}
	}
}
