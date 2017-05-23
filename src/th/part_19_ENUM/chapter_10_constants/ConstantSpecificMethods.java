package th.part_19_ENUM.chapter_10_constants;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 19.10 常量相关的方法
 * 
 * @author ken
 * 2017-5-2 下午02:59:22
 */
public enum ConstantSpecificMethods {
	DATE_TIme{
		String getInfo(){
			return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		}
	},CLASSPATH{
		String getInfo(){
			return System.getenv("CLASSPATH");
		}
	},VERSION{
		String getInfo(){
			return System.getProperty("java.version");
		}
	};
	
	abstract String getInfo();
	/**
	 * 可以编写enum实例方法，从而为enum实例赋予不同的行为
	 * 要实现常量相关方法，需要定义一个或多个抽象方法，
	 * 然后每个enum实例实现此方法
	 * @param args
	 * 2017-5-2 下午03:13:37
	 */
	public static void main(String[] args) {
		for(ConstantSpecificMethods ele:values())
			System.out.println(ele.getInfo());
	}
}