package th.part_19_ENUM.chapter_09_EnumMap;

import java.util.EnumMap;
import java.util.Map;

import th.part_19_ENUM.chapter_08_EnumSet.AlarmPoints;

/**
 * 19.9 ʹ��EnumMap
 * 
 * @author ken 2017-5-2 ����02:37:02
 */
interface Command {
	void action();
};

public class EnumMaps {
	public static void main(String[] args) {
		EnumMap<AlarmPoints, Command> em = new EnumMap<AlarmPoints, Command>(
				AlarmPoints.class);
		em.put(AlarmPoints.KITCHEN, new Command() {
			@Override
			public void action() {
				System.out.println("Kitchen");
			}
		});
		em.put(AlarmPoints.BATHROOM, new Command(){
			@Override
			public void action() {
				System.out.println("Bathroom");
			}
		});
		for (Map.Entry<AlarmPoints, Command> ele : em.entrySet()) {
			System.out.print(ele.getKey()+":");
			ele.getValue().action();
		}
		try {
			//û��keyֵ������NullPointerException
			em.get(AlarmPoints.LOBBY).action();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
