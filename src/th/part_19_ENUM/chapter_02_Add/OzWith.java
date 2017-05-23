package th.part_19_ENUM.chapter_02_Add;

import TIJ4_code.net.mindview.util.OSExecute;

/**
 * 枚举中添加方法
 * 必须在枚举后面添加方法
 * 枚举的构造器只能在其内部使用
 * 
 * @author Administrator
 * 2015-12-8 下午02:36:29
 * 2017-05-3 下午02:14:29
 */
public enum OzWith {
	WEST("At the West"),NOTH("At the North"),EAST("At the EAST"),SOUTH("At the SOUTH");
	
	/**
	 * Enum中的任意类型都是该对象的实例。
	 * 所有类型对象实例将在static块中初始化，而无需外部实例化该对象（外部实例化无任何意义）。
	 * 当然也就不需要public构造方法了
	 */
	private String description;
	private OzWith(String description){
		this.description=description;
	}
	public String getDescription() {
		return description;
	}
	static String fileName="E:\\Eclipse_WS\\ThinkingInJava\\build\\classes\\th\\part_19_ENUM\\chapter_02_Add\\OzWith.class";
	public static void main(String[] args) {
		for(OzWith o:OzWith.values()){
			System.out.println(o+":"+o.getDescription());
		}
		OSExecute.command("javap "+fileName);
	}
}
