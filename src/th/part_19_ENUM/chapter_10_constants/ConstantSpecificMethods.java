package th.part_19_ENUM.chapter_10_constants;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 19.10 ������صķ���
 * 
 * @author ken
 * 2017-5-2 ����02:59:22
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
	 * ���Ա�дenumʵ���������Ӷ�Ϊenumʵ�����費ͬ����Ϊ
	 * Ҫʵ�ֳ�����ط�������Ҫ����һ���������󷽷���
	 * Ȼ��ÿ��enumʵ��ʵ�ִ˷���
	 * @param args
	 * 2017-5-2 ����03:13:37
	 */
	public static void main(String[] args) {
		for(ConstantSpecificMethods ele:values())
			System.out.println(ele.getInfo());
	}
}