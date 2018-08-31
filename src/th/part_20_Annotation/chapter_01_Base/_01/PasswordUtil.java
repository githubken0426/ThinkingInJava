package th.part_20_Annotation.chapter_01_Base._01;

public class PasswordUtil {
	@UserCase(id=47,description="Password must contains last numeric")
	public static boolean validatePassword(String password){
		return password.matches("\\w*\\d\\w*");
	}
	/**
	 * description 指定了默认值，所以可以省略
	 * id 没有默认值，必须赋值，不能省略
	 * @param password
	 * @return
	 */
	@UserCase(id=47)
	public static boolean validatePassword2(String password){
		return password.matches("\\w*\\d\\w*");
	}
}
