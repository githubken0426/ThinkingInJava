package cn.initinalization;

public class Rifle extends Gun {

	static{
		System.out.println("Rifle==������ǹ��");
	}
	public Rifle(int bullet) {
//		super();
		super(bullet);
		System.out.println("Rifle==����������ǹ������"+bullet+"���ӵ���");
	}

}
