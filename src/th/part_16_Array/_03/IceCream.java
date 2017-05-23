package th.part_16_Array._03;

import java.util.Arrays;
import java.util.Random;


public class IceCream {
	private static Random random=new Random(47);
	static final String [] str={"First","Secord","Third"};
	
	public static String[] iceSet(int n){
		if(n>str.length)
			throw new IllegalArgumentException("Set is two big");
		String [] results =new String[n];
		boolean [] picked=new boolean[str.length];
		for(int i=0;i<n;i++){
			int t;
			do
				t=random.nextInt(str.length);
			while(picked[t]);
			results[i]=str[t];
			picked[t]=true;
		}
		return results;
	}
	
	public static void main(String[] args) {
		for(int i=0;i<7;i++){
			System.out.println(Arrays.toString(iceSet(3)));
		}
	}
}
