package th.part_15_Generic.chapter_06_ComplexModel;

import java.util.ArrayList;

import th.part_15_Generic.chapter_04_GenericMethod._03.Generators;

public class ShelfClass {
	public static class Shelf extends ArrayList<Product> {
		public Shelf(){}
		public Shelf(int size) {
			Generators.fill(new Shelf(), Product.generator, size);
		}
	}

	public static class Asile extends ArrayList<Shelf> {
		public Asile(int size, int produceSize) {
			for (int i = 0; i < size; i++) {
				add(new Shelf(produceSize));
			}
		}
	}

	public static class CheckOutStand {
	}

	public static class Coffee {
	}

	public static class Store extends ArrayList<Asile> {
		private ArrayList<CheckOutStand> checkOut = new ArrayList<CheckOutStand>();
		private Coffee coffee = new Coffee();

		public Store(int size, int shelfSize, int productSize) {
			for (int i = 0; i < size; i++) {
				add(new Asile(shelfSize, productSize));
			}
		}

		public String toString() {
			StringBuffer sb = new StringBuffer();
			for (Asile a : this) {
				for (Shelf s : a) {
					for (Product p : s) {
						sb.append(p);
						sb.append("\n");
					}
				}
			}
			return sb.toString();
		}
	}

}
