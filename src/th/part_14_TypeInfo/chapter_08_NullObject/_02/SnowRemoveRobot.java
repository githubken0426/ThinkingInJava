package th.part_14_TypeInfo.chapter_08_NullObject._02;

import java.util.Arrays;
import java.util.List;

import th.part_14_TypeInfo.chapter_08_NullObject.Robot;

public class SnowRemoveRobot implements Robot {
	private String name;
	
	public SnowRemoveRobot(String name){
		this.name=name;
	}
	
	@Override
	public String name() {
		return this.name;
	}

	@Override
	public String model() {
		return "Snowbot 11N";
	}

	@Override
	public List<Operation> operation() {
		return Arrays.asList(new Operation(){
			@Override
			public String description() {
				return name+" can shovel snow";
			}

			@Override
			public void command() {
				System.out.println(name+" shoveling snow");
			}
		},new Operation(){
			@Override
			public String description() {
				return name+" can chip ice";
			}

			@Override
			public void command() {
				System.out.println(name+" chipping snow");
			}
		},new Operation(){
			@Override
			public String description() {
				return name+" can clrear roof";
			}

			@Override
			public void command() {
				System.out.println(name+" clrearing roof");
			}
		});
	}
	
	public static void main(String[] args) {
		Robot.test.doWork(new SnowRemoveRobot("Slusher"));
	}

}
