package th.part_16_Array._07_Arrays;

import java.util.Random;

import TIJ4_code.net.mindview.util.Generator;

public class ComType implements Comparable<ComType> {
	int i,j;
	private static int count=1;
	
	public ComType(int n1,int n2){
		i=n1;
		j=n2;
	}
	
	public String toString(){
		String result="[i="+i+",j="+j+"]";
		if(count++ %3==0){
			result="\n";
		}
		return result;
	}
	
	@Override
	public int compareTo(ComType o) {
		return (i<o.i ? -1:(i==o.i? 0: 1));
	}
	
	private static Random random=new Random(47);
	public static Generator<ComType> generator(){
		return new Generator<ComType>(){
			@Override
			public ComType next() {
				return new ComType(random.nextInt(100),random.nextInt(100));
			}
		};
	}
	
	public static void main(String[] args) {
		
	}
}
