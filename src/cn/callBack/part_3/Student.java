package cn.callBack.part_3;
/**
 * part3:ʹ�ü��������
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
	private void callHelp(double a, double b){
		 SuperCalculator.calcADD(a, b,this);
	}
	//��շ���
	public  void fillBank(double a, double b,double result) {
		System.out.println(name + "ʹ�ü�����������:" + a + "+" + b + "=" +result);
	}
	
	/**
	 * С��ͨ�������callHelp����������С��(new SuperCalculator())��calcADD������
	 * �ڵ��õ�ʱ����������ã�this����������һ�����룬
	 * С����ʹ�ü������ó����֮�󣬻ص���С����fillBlank����������������˺ڰ��ϵĿո���
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Student stu=new Student("С��");
		stu.callHelp(1625.00,4306.03);
	}
}
