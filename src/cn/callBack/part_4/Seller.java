package cn.callBack.part_4;

public class Seller implements DoJob {
	private String name;

	public Seller(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void fillBank(double a, double b, double result) {
		System.out.println(name + "����С�����:" + a + " + " + b + " = " + result);
	}
	
	//���㷽��
	public void callHelp(double a,double b) {
		System.out.println(name+"�ȴ�������....");
		SuperCalculator.calcADD(a, b, this);
	}

	public static void main(String[] args) {
		Seller seller=new Seller("����");
		seller.callHelp(12589.2, 12300.0);
	}
}
