package th.about.other;

import java.util.Random;

public class RandomAndSeed {
	public static void main(String[] args) {
		/**
		 * �����ӵ�������ǹ̶��ġ�
		 */
		Random random1=new Random();
		Random random2=new Random(47);
		for(int i=0;i<4;i++){
			System.out.println("��:"+random1.nextInt(10));
			System.out.println("������:"+random2.nextInt(10));
		}
		
	}
}
