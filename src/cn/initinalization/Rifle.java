package cn.initinalization;

public class Rifle extends Gun {

	static{
		System.out.println("Rifle==》来复枪！");
	}
	public Rifle(int bullet) {
//		super();
		super(bullet);
		System.out.println("Rifle==》我是来复枪，我有"+bullet+"发子弹！");
	}

}
