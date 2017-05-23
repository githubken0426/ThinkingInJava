package cn.callBack.synchronize;

public class TestMain {
	public static void main(String[] args) {
		new Student("xiaoming").callBack(123.23,325.20);
		
		new Seller("Seller").callBack(1203.23,4325.26);
	}
}
