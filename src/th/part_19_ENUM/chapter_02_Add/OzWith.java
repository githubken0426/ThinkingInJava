package th.part_19_ENUM.chapter_02_Add;

import TIJ4_code.net.mindview.util.OSExecute;

/**
 * ö������ӷ���
 * ������ö�ٺ�����ӷ���
 * ö�ٵĹ�����ֻ�������ڲ�ʹ��
 * 
 * @author Administrator
 * 2015-12-8 ����02:36:29
 * 2017-05-3 ����02:14:29
 */
public enum OzWith {
	WEST("At the West"),NOTH("At the North"),EAST("At the EAST"),SOUTH("At the SOUTH");
	
	/**
	 * Enum�е��������Ͷ��Ǹö����ʵ����
	 * �������Ͷ���ʵ������static���г�ʼ�����������ⲿʵ�����ö����ⲿʵ�������κ����壩��
	 * ��ȻҲ�Ͳ���Ҫpublic���췽����
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
