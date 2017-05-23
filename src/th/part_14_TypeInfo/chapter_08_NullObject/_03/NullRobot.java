package th.part_14_TypeInfo.chapter_08_NullObject._03;

import java.lang.reflect.Proxy;

import th.part_14_TypeInfo.chapter_08_NullObject.NullInterface;
import th.part_14_TypeInfo.chapter_08_NullObject.Robot;
import th.part_14_TypeInfo.chapter_08_NullObject._02.SnowRemoveRobot;

public class NullRobot {
	private static Robot newNullRobot(Class<? extends Robot> type){
		return (Robot) Proxy.newProxyInstance
						(NullRobot.class.getClassLoader(), 
						new Class[]{NullInterface.class,Robot.class }, 
						new NullRobotProxyHnadler(type));
	}
	
	public static void main(String[] args) {
		Robot[] robot={new SnowRemoveRobot("SnowB"),newNullRobot(SnowRemoveRobot.class)};
		for (Robot robot2 : robot) {
			Robot.test.doWork(robot2);
		}
		
	}
}
