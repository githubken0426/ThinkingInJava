package th.part_13_String.chaper_05;

import java.io.PrintStream;
import java.util.Formatter;

public class Turtle {
	private String name;
	private Formatter f;
	
	public Turtle(String name,Formatter f){
		this.name=name;
		this.f=f;
	}
	
	public void move(int x,int y){
		f.format("%s The Turlte is at (%d,%d)\n",name,x,y);
	}
	
	public static void main(String[] args) {
		PrintStream ps=System.out;
		Turtle tommy=new Turtle("Tommy",new Formatter(System.out));
		Turtle terry=new Turtle("terry",new Formatter(ps));
		
		tommy.move(0, 0);
		terry.move(2, 2);
	}
}
