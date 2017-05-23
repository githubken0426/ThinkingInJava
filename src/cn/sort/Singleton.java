package cn.sort;

public class Singleton {
	/*
	 * 1. �̲߳���ȫ. ����д��lazy loading�����ԣ��������������ڶ��̲߳�������������
	 */
	private static Singleton instance;

	private static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	/*
	 * 2. �̰߳�ȫ. ����д���ܹ��ڶ��߳��кܺõĹ����� ��Ҳ�߱��ܺõ�lazy loading��
	 * ���ǣ�Ч�ʺܵ� ���������²���Ҫͬ��
	 */
	private static Singleton instance2;

	private static synchronized Singleton getInstance2() {
		if (instance2 == null) {
			instance2 = new Singleton();
		}
		return instance2;
	}

	/*
	 * 3. ���ַ�ʽ����classloder���Ʊ����˶��̵߳�ͬ�����⣬ ������instance����װ��ʱ��ʵ������
	 * ��Ȼ������װ�ص�ԭ���кܶ��֣��ڵ���ģʽ�д�������ǵ���getInstance������ 
	 * ����Ҳ����ȷ���������ķ�ʽ�����������ľ�̬������������װ�أ�
	 * ��ʱ���ʼ��instance��Ȼû�дﵽlazy loading��Ч��
	 */
	private static Singleton instance3;
	static {
		instance3 = new Singleton();
	}

	public static Singleton getInstance3() {
		return instance3;
	}

	/*
	 * 4 ���ַ�ʽͬ��������classloder�Ļ�������֤��ʼ��instanceʱֻ��һ���߳�
	 */
	private static class SingletonHolder {
		private static final Singleton INSTANCE = new Singleton();
	}

	public static final Singleton getInstance4() {
		return SingletonHolder.INSTANCE;
	}

	/*
	 * 5.ö�ٵ��� ���ַ�ʽ��Effective Java����Josh Bloch �ᳫ�ķ�ʽ��
	 * �������ܱ�����߳�ͬ�����⣬���һ��ܷ�ֹ�����л����´����µĶ���; ���SingletonEnum ��д��
	 */

	/*
	 * 6. ˫��У���� 
	 * һ������Ϊvolatile�ı�����˵��������ܻᱻ���벻���ظı䣬 �������������Ͳ���ȥ�������������ֵ��
	 * ����ȷ��˵���ǣ��Ż������õ��������ʱ����ÿ�ζ�С�ĵ����¶�ȡ���������ֵ�� 
	 * ������ʹ�ñ����ڼĴ�����ı��ݡ�
	 * ���⣺
	 * 1.��������ɲ�ͬ����װ����װ�룬�Ǳ��п��ܴ��ڶ���������ʵ�����ٶ�����Զ�˴�ȡ��
	 * ����һЩservlet������ÿ��servletʹ����ȫ��ͬ����װ������
	 * �����Ļ����������servlet����һ�������࣬���ǾͶ����и��Ե�ʵ����
	 * 2.���Singletonʵ����java.io.Serializable�ӿڣ���ô������ʵ���Ϳ��ܱ����л��͸�ԭ��
	 * ������������������л�һ��������Ķ��󣬽�������ԭ����Ǹ���������ͻ��ж���������ʵ����
	 */
	private volatile static Singleton INSTANCE6;

	public static Singleton getInstance6() {
		if (INSTANCE6 == null) {
			synchronized (Singleton.class) {
				if (INSTANCE6 == null) {
					INSTANCE6 = new Singleton();
				}
			}
		}
		return INSTANCE6;
	}

	/**
	 * ����ö�ٷ���
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		// ����ö��
		for (SingletonEnum c : SingletonEnum.values()) {
			System.out.println(c.sayHi());
		}
		SingletonEnum.INSTANCE.getInstance();
	}
}
