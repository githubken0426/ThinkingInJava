package th.about.other;

import java.util.Random;

public class RandomAndSeed {
	public static void main(String[] args) {
		/**
		 * 有种子的随机数是固定的。
		 */
		Random random1=new Random();
		Random random2=new Random(47);
		for(int i=0;i<4;i++){
			System.out.println("无:"+random1.nextInt(10));
			System.out.println("有种子:"+random2.nextInt(10));
		}
		
	}
}
