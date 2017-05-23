package th.part_14_TypeInfo.exercise._08;

public class E08_Exercise {
	private static void printClasses(Class<?> c){
		if(c==null) return ;
		System.out.println("getName():"+c.getName());
		System.out.println("declare:"+c.getDeclaredFields());
		for (Class<?> ele : c.getInterfaces()) {
			System.out.println("Interface:"+ele.getName());
			printClasses(ele.getSuperclass());
		}
		printClasses(c.getSuperclass());
	}
	
	public static void main(String[] args) throws Exception {
		for (String arg : args) {
			System.out.println("--arg--:"+arg);
			printClasses(Class.forName(arg));
		}
	}
}
