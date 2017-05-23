package th.part_14_TypeInfo.chapter_08_NullObject._01;

import java.util.ArrayList;

public class Stuff extends ArrayList<Position> {
	
	public void add(String title,Person person){
		add(new Position(title,person));
	}
	
	public void add(String ...titles){
		for (String string : titles) {
			add(new Position(string));
		}
	}
	
	public Stuff(String ...titles){
		add(titles);
	}
	
	public boolean positionAvailable(String title){
		for(Position po:this){
			if(po.getTitle().equals(title)&&po.getPerson()==Person.NULL){
				return true;
			}
		}
		return false;
	}
	
	public void fillPosition(String title,Person hire){
		for(Position po:this){
			if(po.getTitle().equals(title)&&po.getPerson()==Person.NULL){
				po.setPerson(hire);
				return;
			}
		}
		throw new RuntimeException("Position:"+title+" not avaiable!");
	}
	
	public static void main(String[] args) {
		Stuff stuff=new Stuff("President","CTO",
				"Marking Manager","Product Manager","Project Lead","Software Engineer",
				"Software Engineer","Software Engineer","Test Engineer","Techical Writer");
		stuff.fillPosition("President", new Person("Me","Last","The Top"));
		stuff.fillPosition("Project Lead", new Person("Janet","Planner","The Burbs"));
		if(stuff.positionAvailable("Software Engineer")){
			stuff.fillPosition("Software Engineer", new Person("Coder","bob","Bright light city"));
		}
		System.out.println(stuff);
		
	}
}
