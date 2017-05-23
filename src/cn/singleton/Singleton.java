package cn.singleton;

public class Singleton {

	private static Singleton instance;

	private Singleton() {
	}

	/**
	 * 1.���̰߳�ȫ
	 */
	public static Singleton singleInstance1() {
		if (instance == null)
			instance = new Singleton();
		return instance;
	}

	/**
	 * 2.Ч�ʽϵ� �������²���Ҫͬ��
	 * 
	 * @return 2017-5-12 ����11:27:57
	 */
	public static synchronized Singleton singleInstance2() {
		if (instance == null)
			instance = new Singleton();
		return instance;
	}

	/**
	 * 3.����classloder���Ʊ����˶��̵߳�ͬ������ ������instance����װ��ʱ��ʵ����,
	 * ��ʱ���ʼ��instance��Ȼû�дﵽlazy loading��Ч��
	 * 
	 * @return 2017-5-12 ����11:27:57
	 */
	private static Singleton singel = new Singleton();

	public static Singleton singleInstance3() {
		return singel;
	}

	/**
	 * 4.�ڲ���ʵ�� ��ʹSingleton�౻װ���ˣ�instance��һ������ʼ��
	 * 
	 * @author ken 2017-5-12 ����11:48:14
	 */
	private static class HolderSingle {
		private static Singleton SINGEL = new Singleton();
	}

	public static Singleton singleInstance4() {
		return HolderSingle.SINGEL;
	}

	/**
	 * 5.ö��ʵ��
	 * 
	 * @author ken 2017-5-12 ����11:54:21
	 */
	public static enum EnumSingle {
		SINGEL {
			@Override
			public Singleton getInstance() {
				System.out.println("ö�ٵ���");
				return new Singleton();
			}
		};
		public abstract Singleton getInstance();
	}
	/**
	 * 6.˫��У����
	 * @return
	 * 2017-5-12 ����12:00:23
	 */
	public static Singleton singleInstance5() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null)
					instance = new Singleton();
			}
		}
		return instance;
	}

	public static void main(String[] args) {
		Singleton singel = EnumSingle.SINGEL.getInstance();
	}

}
