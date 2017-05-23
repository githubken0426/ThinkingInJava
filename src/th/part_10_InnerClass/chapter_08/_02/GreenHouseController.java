package th.part_10_InnerClass.chapter_08._02;

public class GreenHouseController extends Controller {
	private boolean light =false;
	//light on
	public class LightOn extends Event{

		public LightOn(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			light=true;
		}
		public String toString(){
			return "Light is on!";
		}
	}
	//light off
	public class LightOff extends Event{

		public LightOff(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			light=false;
		}
		public String toString(){
			return "Light is off!";
		}
	}
	
	private boolean water =false;
	
	//water on
	public class WaterOn extends Event{

		public WaterOn(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			water=true;
		}
		public String toString(){
			return "Water is on!";
		}
	}
	//water off
	public class WaterOff extends Event{

		public WaterOff(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			water=false;
		}
		public String toString(){
			return "Water is off!";
		}
	}
	// restart
	public class Restart extends Event{
		private Event[] eventList;
		public Restart(long delayTime,Event[] eventList) {
			super(delayTime);
			this.eventList=eventList;
			for (Event event : eventList) {
				addEvent(event);
			}
		}

		@Override
		public void action() {
			for (Event event : eventList) {
				event.start();
				addEvent(event);
			}
		}
		public String toString(){
			return "Restarting System!";
		}
	}
	
	public static class Terminate extends Event{

		public Terminate(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			System.exit(0);
		}
		public String toString(){
			return "Terminate";
		}
	}
}
