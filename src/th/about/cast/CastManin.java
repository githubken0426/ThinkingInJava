package th.about.cast;


public class CastManin {

	public static void main(String[] args) {
		Object obj=-1;
		castStatic(null);
		dynamicKnow(obj);
		int a=1;
		Student stu=new Student();
		dynamicUnknow(stu);
		
	}
	
	/**
	 * ��̬ת��
	 */
	public static void castStatic(Object obj){
		System.out.println("���Ǿ�̬ת������:");
		//null���Ա��κζ�������
		if(obj instanceof Integer){
			Integer objInt=(Integer) obj;
			System.out.println("ת�ͳɹ�:"+objInt);
		}
	}
	/**
	 * ��̬ת��֪����
	 * ת�ɵ����ͣ�Ҳ���ڱ����ھ�֪���ģ�û��Ҫ��ô��
	 */
	public static void dynamicKnow(Object obj){
		System.out.println("���Ƕ�̬ת��֪��������:");
		if(Integer.class.isInstance(obj)){
			Integer objInt=Integer.class.cast(obj);
			System.out.println("ת�ͳɹ�:"+objInt);
		}
	}
	/**
	 * ��̬תδ֪����
	 */
	public static void dynamicUnknow(Object obj){
		System.out.println("���Ƕ�̬תδ֪��������:");
		Class<Student> type=null;
		if(type.isInstance(obj)){
			Student stu=type.cast(obj);
		}
		
	}
}
