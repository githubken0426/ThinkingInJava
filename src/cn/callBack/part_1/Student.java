package cn.callBack.part_1;
/**
 * part1������
 * @author Administrator
 *
 */
public class Student {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public Student(String name) {
		this.name = name;
	}
	//���㷽��
	private double calcADD(double a, double b) {
		return a + b;
	}
	//��շ���
	public void fillBank(double a, double b) {
		System.out.println(name + "�ļ�����:" + a + "+" + b + "=" + calcADD(a,b));
	}
	
	/**
	 * �ù�����ȫ��Student���ʵ�����󵥶���ɣ���δ�漰�ص�����
	 * @param args
	 */
	public static void main(String[] args) {
		Student stu=new Student("С��");
		stu.fillBank(15.00,36.03);
	}
}
