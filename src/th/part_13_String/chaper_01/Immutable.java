package th.part_13_String.chaper_01;

public class Immutable {
	public static String upCase(String str){
		return str.toUpperCase();
	}
	/**
	 * q���ݵ�ֻ��һ������copy,str��һ���µ�String����
	 * ��String��������������ʱ�����ݵ����临�Ƶ�����
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
