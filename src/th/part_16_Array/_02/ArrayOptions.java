package th.part_16_Array._02;

import java.util.Arrays;

import th.part_16_Array._01.BerylliumSphere;

public class ArrayOptions {
	static{
		int [] d=new int[]{};
		int [] d2=new int[]{1,2};
		int [] d3={1,2};
	}
	public static void main(String[] args) {
		BerylliumSphere [] a;
		//引用类型默认会初始化为null
		BerylliumSphere [] b=new BerylliumSphere[5];
		System.out.println(Arrays.toString(b));
		
		BerylliumSphere [] c=new BerylliumSphere[5];
		for(int i=0;i<c.length;i++)
			if(c[i]==null)
				c[i]=new BerylliumSphere();
		//聚集初始化
		BerylliumSphere [] d={new BerylliumSphere(),new BerylliumSphere()};
		a=d;
		/**
		 * 虽然可以访问数组大小，但是无法获取数组的确切元素个数
		 */
		System.out.println("a.length:"+a.length);
		System.out.println("b.length:"+b.length);
		System.out.println("c.length:"+c.length);
		System.out.println("d.length:"+d.length);
		
		char ch[]=new char[5];
		System.out.println("ch[0]="+ch[0]);
		System.out.println("ch[0]="+(int)ch[0]);
	}
}
