package cn.callBack.part_2;

/**
 * part2:ʹ�ü��������
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
	private double useCalculator(double a, double b){
		return Calculator.calcADD(a, b);
	}
	//��շ���
	public  void fillBank(double a, double b) {
		System.out.println(name + "ʹ�ü�����������:" + a + "+" + b + "=" + useCalculator(a,b));
	}
	
	/**
	 * �ù�������δ�漰���ص����ƣ�
	 * ���ǲ���С���Ĳ��ֹ����Ѿ�ʵ����ת�ƣ��ɼ�������Э��ʵ��
	 * @param args
	 */
	public static void main(String[] args) {
		Student stu=new Student("С��");
		stu.fillBank(165.00,306.03);
	}
}
