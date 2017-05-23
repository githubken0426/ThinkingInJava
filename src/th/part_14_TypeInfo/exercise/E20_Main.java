package th.part_14_TypeInfo.exercise;

public class E20_Main {
	private static void display(String args,Object[] obj){
		System.out.println(args);
		for (Object object : obj) {
			System.out.println(object);
		}
	}
	
	private static void classInfo(Class<?> c)throws Exception{
		System.out.println("c.getName():"+c.getName());
		System.out.println("c.getPackage():"+c.getPackage());
		System.out.println("c.getSuperclass():"+c.getSuperclass());
		display("c.getDeclaredClasses():",c.getDeclaredClasses());
		display("c.getClasses():",c.getClasses());
		display("c.getInterfaces():",c.getInterfaces());
		display("c.getDeclaredMethods():",c.getDeclaredMethods());
		display("c.getMethods():",c.getMethods());
		display("c.getDeclaredConstructors():",c.getDeclaredConstructors());
		display("c.getConstructors():",c.getConstructors());
		display("c.getDeclaredFields():",c.getDeclaredFields());
		display("c.getFields():",c.getFields());
		if(c.getSuperclass()!=null){
			System.out.println("Base Class:"+c.getSuperclass());
			classInfo(c.getSuperclass());
		}
		System.out.println("end of"+c.getName());
	}
	
	public static void main(String[] args) throws ClassNotFoundException, Exception {
		for (String str : args) {
			classInfo(Class.forName(str));
		}
	}
}
