package th.part_16_Array._07_Arrays._03;

import java.util.Random;

import TIJ4_code.net.mindview.util.Generator;

/**
 * 基本类型的数组可以直接排序,
 * 但是引用类型的数组不能直接排序,需要实现Comparable接口
 * 
 * 如果不实现java.lang.Comparable，调用Arrays.sort(CompType[])，
 * 会出现cannot be cast to java.lang.Comparable
 * @author ken
 * 2017-6-1 上午09:06:26
 */
public class CompType implements Comparable<CompType> {
	int i,j;
	private static int count=1;
	
	public CompType(int n1,int n2){
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
	public int compareTo(CompType o) {
		return (i<o.i ? -1:(i==o.i? 0: 1));
	}
	
	private static Random random=new Random(47);
	public static Generator<CompType> generator(){
		return new Generator<CompType>(){
			@Override
			public CompType next() {
				return new CompType(random.nextInt(100),random.nextInt(100));
			}
		};
	}
}
