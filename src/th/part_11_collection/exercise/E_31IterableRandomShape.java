package th.part_11_collection.exercise;

import java.util.Iterator;
import java.util.Random;

import TIJ4_code.polymorphism.shape.Circle;
import TIJ4_code.polymorphism.shape.Shape;
import TIJ4_code.polymorphism.shape.Square;
import TIJ4_code.polymorphism.shape.Triangle;



public class E_31IterableRandomShape {
	
	static class RandomShapeGenerator implements Iterable<Shape>{
		private Random rand=new Random(47);
		private final int quantity;
		RandomShapeGenerator(int quantity){
			this.quantity=quantity;
		}
		@Override
		public Iterator<Shape> iterator() {
			return new Iterator<Shape>(){
				private int index=0;
				@Override
				public boolean hasNext() {
					return index<quantity;
				}

				@Override
				public Shape next() {
					index++;
					return nextShape();
				}

				@Override
				public void remove() {
					throw new UnsupportedOperationException();
				}
			};
		}
		private Shape nextShape(){
			switch(rand.nextInt(3)){
				default :
				case 0:return new Circle();
				case 1:	return new Square();
				case 2:return new Triangle();
			}
		}
	}
	
	public static void main(String[] args) {
		for(Shape r:new RandomShapeGenerator(10)){
			System.out.println(r.getClass().getSimpleName());
		}
	}
}
