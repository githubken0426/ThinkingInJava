package th.part_20_Annotation.chapter_03;

@ExtractInterface("IMutipiler")
public class Mutipiler {
	public static int mutiply(int x,int y){
		int total=0;
		for(int i=0;i<x;i++)
			total=add(total,y);
		return total;
	}
	private static int add(int x,int y){
		return x+y;
	}
	
	public static void main(String[] args) {
		System.out.println("10*16="+Mutipiler.mutiply(10,16));
	}
}
