package th.part_18_IO.exercise;

/**
 * 练习11
 * @author Administrator
 * 2015-11-25 05:09:38
 *
 */
public class E11_GreenHouseController {
	public static void main(String[] args) {
		GreenHouseController g=new GreenHouseController("E:\\Eclipse_WS\\ThinkingInJava\\src\\th\\part_18_IO\\exercise\\GreenHouseController.java");
		if(args.length==1){
			g.addEvent(null);
		}
		g.run();
	}
}
