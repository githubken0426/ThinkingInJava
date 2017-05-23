package th.part_13_String.chaper_05;

public class SimpleFormat {
	public static void main(String[] args) {
		int x=5;
		double y=5.332542;
		System.out.println("Row1:["+x+" "+y+"]");
		System.out.format("Row2:[%d %f]\n",x,y);
		System.out.format("Row3:",x,y);
	}
}
