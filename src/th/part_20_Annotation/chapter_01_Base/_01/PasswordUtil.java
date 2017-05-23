package th.part_20_Annotation.chapter_01_Base._01;

public class PasswordUtil {
	@UserCase(id=47,description="Password must contains last numeric")
	public static boolean validatePassword(String password){
		return password.matches("\\w*\\d\\w*");
	}
	/**
	 * description ָ����Ĭ��ֵ�����Կ���ʡ��
	 * id û��Ĭ��ֵ�����븳ֵ������ʡ��
	 * @param password
	 * @return
	 */
	@UserCase(id=47)
	public static boolean validatePassword2(String password){
		return password.matches("\\w*\\d\\w*");
	}
}
