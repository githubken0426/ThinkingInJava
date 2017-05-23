package th.part_10_InnerClass.chapter_08._02;

import java.util.ArrayList;
import java.util.List;

public class Controller {
	private List<Event> eventList=new ArrayList<Event>();
	public void addEvent(Event event){
		eventList.add(event);
	}
	
	public void run(){
		while(eventList.size()>0){
			for (Event ele : new ArrayList<Event>(eventList))
				if(ele.ready()){
					System.out.println(ele);
					ele.action();
					eventList.remove(ele);
				}
		};
	}
}
