package cn.dll;
/**
 * java native interface
 * dynamic link library
 * java���ö�̬��
 * @author Administrator
 * 2016-1-13 ����10:01:45
 *
 */
public class MyJNI {
	static{
		//�����չ���ֿ��Բ���д������������DLL����SO����ϵͳ�Լ��ж���ǰ�᣺��dll�������������
		System.loadLibrary("user32");
	}
	//����Խ�Ҫ���õķ�������������,����Ҫ����ʵ��
	public native static void MessageBoxA();
	public native static int getAge();
	
	/**
	 * java.lang.UnsatisfiedLinkError: cn.dll.MyJNI.MessageBoxA()V
	 * user32�Ѿ��̶��˰�����������Ҫ��Ӧ���е���ʱ����Ҫ���������
	 * @param args
	 */
	public static void main(String[] args) {
		MyJNI.MessageBoxA();
	}
}
