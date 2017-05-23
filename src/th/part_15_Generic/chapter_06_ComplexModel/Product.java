package th.part_15_Generic.chapter_06_ComplexModel;

import java.util.Random;

import th.util.Generator;

public class Product {
	private final int id;
	private String description;
	private double price;
	
	public Product(int id,String description,double price){
		this.id=id;
		this.description=description;
		this.price=price;
		System.out.println(toString());
	}
	
	public String toString(){
		return "Id:"+id+":"+description+",price $"+price;
	}
	
	public void priceChange(double price){
		this.price+=price;
	}
	
	public static Generator<Product> generator=new Generator<Product>(){
		Random random=new Random(47);
		@Override
		public Product next() {
			return new Product(random.nextInt(1000),"Test", Math.round(random.nextDouble()*1000.0)+0.99);
		}
	};
	
}
