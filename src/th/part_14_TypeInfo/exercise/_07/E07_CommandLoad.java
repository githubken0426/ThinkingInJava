package th.part_14_TypeInfo.exercise._07;


public class E07_CommandLoad {

	public static void main(String[] args) {
		try {
			for (String arg : args) {
				Class.forName(arg);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
