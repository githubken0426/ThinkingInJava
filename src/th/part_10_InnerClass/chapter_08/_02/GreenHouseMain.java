package th.part_10_InnerClass.chapter_08._02;

public class GreenHouseMain {
	public static void main(String[] args) {
		GreenHouseController gc=new GreenHouseController();
		Event[] eventList=new Event[]{
				gc.new LightOn(200),gc.new LightOff(400),
				gc.new WaterOn(600),gc.new WaterOff(800)
		};
		gc.addEvent(gc.new Restart(2000,eventList));
		gc.run();
	}
}
