package th.part_19_ENUM.chapter_01_Base._00;


public class ENUMClass {
	/**
	 * ordinal()返回枚举常量的序数.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		for(Shrubbary s:Shrubbary.values()){
			System.out.println(s+" ordinal:"+s.ordinal());
			System.out.print(s.compareTo(Shrubbary.GRAWLING)+" ");//比较此枚举ordinal与指定对象ordinal的顺序
			System.out.println(s.equals(Shrubbary.GRAWLING)+" "+(s==Shrubbary.GRAWLING));
			System.out.println(s.getDeclaringClass());
			System.out.println(s.name());
		}
		System.out.println("**************************<Shrubbary>");
		for(String s:"GROUND,GRAWLING,HAANGING".split(",")){
			Shrubbary bary=Enum.valueOf(Shrubbary.class, s);
			System.out.println(bary);
		}
	}
}
