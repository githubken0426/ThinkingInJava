package cn.callBack.part_4.asychonous;

public class TestMain {
	public static void main(String[] args) {
		Student stu=new Student("jack");
		stu.callHelp(1693.80, 2863.05);
		
		Seller seller=new Seller("ken");
		seller.callHelp(9693.00, 8863.0);
		
	}
}
