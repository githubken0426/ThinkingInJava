package cn.initinalization;

public class Gun {
	public static int bullet;
	static{
		System.out.println("Gun==������"+bullet+"���ӵ���");
	}
	public Gun(){
		System.out.println("û���ӵ�");
	}
	public Gun(int bull){
		bullet=bull;
		System.out.println("Gun==�������������"+bullet+"���ӵ���");
	}
}
