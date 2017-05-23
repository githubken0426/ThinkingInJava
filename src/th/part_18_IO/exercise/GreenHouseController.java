package th.part_18_IO.exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.LinkedList;

import th.util.Controller;
import th.util.Event;

public class GreenHouseController extends Controller {
	/**
	 * ReStart
	 * @author Administrator
	 * 2015-11-25 ÏÂÎç04:22:23
	 *
	 */
	class ReStart extends Event{
		private Event [] eventList;
		public ReStart(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			for (Event ele : eventList) {
				ele.start();
				addEvent(ele);
			}
			start();
			addEvent(this);
		}
		public String toString(){
			return "ReStart System";
		}

		public void setEventList(Event[] eventList) {
			this.eventList = eventList;
		}
	}
	/**
	 * GHEventFactory
	 * @author Administrator
	 * 2015-11-25 ÏÂÎç04:22:32
	 *
	 */
	class GHEventFactory{
		LinkedList<EventCreator> events=new LinkedList<EventCreator>();
		
		public GHEventFactory(String eventFile){
			try {
				BufferedReader read=new BufferedReader(new FileReader(eventFile));
				String str;
				while((str=read.readLine())!=null){
					int colon=str.indexOf(":");
					String className=str.substring(0,colon).trim();
					Class<?> outer= className.equals("ReStart")?GreenHouseController.class:Controller.class;
					String type=outer.getName()+"$"+className;
					long offset=Long.parseLong(str.substring(1+colon).trim());
					Class<Event> eventClasses=(Class<Event>) Class.forName(type);
					Constructor<Event> ctor=eventClasses.getConstructor(new Class[]{outer,Long.class});
					events.add(new EventCreator(ctor,offset));
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
		
		//EventCreator
		class EventCreator{
			Constructor<Event> ctor;
			long offset;
			public EventCreator(Constructor<Event> ctor,long offset){
				this.ctor=ctor;
				this.offset=offset;
			}
		}
		
		Iterator<Event> iterator(){
			return new Iterator<Event>(){
				Iterator<EventCreator> it=events.iterator();
				@Override
				public boolean hasNext() {
					return it.hasNext();
				}

				@Override
				public Event next() {
					EventCreator ec=it.next();
					Event returnVal=null;
					try {
						returnVal=ec.ctor.newInstance(new Object[]{GreenHouseController.this,ec.offset});
						
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
					return returnVal;
				}

				@Override
				public void remove() {
					throw new UnsupportedOperationException();
				}
			};
		}
	}
	
	GHEventFactory factory;
	public GreenHouseController(String initFile){
		factory=new GHEventFactory(initFile);
		LinkedList<Event> restartableEvent=new LinkedList<Event>();
		Iterator<Event> it=factory.iterator();
		while(it.hasNext()){
			Event e=it.next();
			if( e instanceof ReStart){
				continue;
			}
			restartableEvent.add(e);
		}
		it=factory.iterator();
		while(it.hasNext()){
			Event e=it.next();
			addEvent(e);
			if( e instanceof ReStart){
				((ReStart) e).setEventList(restartableEvent.toArray(new Event[0]));
			}
		}
	}
}
