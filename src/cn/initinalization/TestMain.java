package cn.initinalization;

public class TestMain {
	public static void main(String[] args) {
		try {
			Class.forName("cn.initinalization.Gun");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Gun gun=new Rifle(16);
	}
}
