package th.part_13_String.chaper_01;

public class Immutable {
	public static String upCase(String str){
		return str.toUpperCase();
	}
	/**
	 * q传递的只是一个引用copy,str是一个新的String对象
	 * 把String对象当做参数传递时，传递的是其复制的引用
	 * @param args
	 */
	public static void main(String[] args) {
		String q="this is not my copy";
		String str=upCase(q);
		System.out.println(str);
		
		StringBuilder sb=new StringBuilder();
		
		System.out.println(q.indexOf("o"));
		//System.out.format(format, args);
	}
}
