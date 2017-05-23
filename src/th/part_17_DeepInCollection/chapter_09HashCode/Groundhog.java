package th.part_17_DeepInCollection.chapter_09HashCode;

import java.util.Random;

/**
 * 17.9
 * É¢ÁĞÂë
 * ÍÁ°ÎÊó
 * 
 * @author ken
 * 2017-1-12 ÏÂÎç05:29:28
 */
public class Groundhog {
	protected int number;
	public Groundhog(int number){
		this.number=number;
	}
	public String toString(){
		return "Groundhog#"+number;
	}
	public static void main(String[] args) {
		Random random1=new Random();
		System.out.println(random1.nextInt(100));
		Random random=new Random(47);
		System.out.println(random.nextDouble());
	}
}
