package cn.callBack.part_4;

/**
 * part2:ʹ�ü��������
 * @author Administrator
 *
 */
public class Student implements DoJob{
	private String name;
	public void setName(String name) {
		this.name = name;
	}
	public Student(String name) {
		this.name = name;
	}
	@Override
	public void fillBank(double a, double b, double result) {
		System.out.println(name + "����С�����:" + a + " + " + b + " = " + result);
	}
	
	//���㷽��
	public void callHelp(double a, double b){
		System.out.println(name+"�ȴ�������....");
		SuperCalculator.calcADD(a, b,this);
	}
	/**
	 * С��ϣ���Ժ󲻽���С���ṩ�������
	 * ��ϣ������������С�������ṩ������������Ժ��ܹ���չ�����˵�ҵ��
	 * �����������еĹ˿�Լ����һ���취������ͳһ�Ĵ���
	 * ���ͳһ�ķ�����С��������һ���ӿڣ��ṩ���˴�ҡ�
	 * @param args
	 */
	public static void main(String[] args) {
		Student stu=new Student("С��");
		stu.callHelp(165.00,306.03);
	}
}
