package th.part_21_Concurrence.chapter_03._02Synchronized._05Critical.noInner;

public class Pair {
	private int x,y;
	public Pair(){
		this(0,0);
	}
	public Pair(int x,int y){
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x++;
	}
	public int getY() {
		return y++;
	}
	
	public void incrementX(){++x;}
	
	public void incrementY(){++y;}
	
	public String toString(){
		return "X:"+x+",Y:"+y;
	}
}
