package cn.encrypt;

public class TokenUtil {
	/**
	 * 解析出token
	 */
	public static String userid(String token) {
		if (null == token || token.isEmpty()) {
			return null;
		}
		String code = Encrypt.decode(token);
		return code.substring(0, code.indexOf("_"));
	}

	public static String device(String token) {
		if (null == token || token.isEmpty()) {
			return null;
		}
		String code = Encrypt.decode(token);
		String s[] = code.split("_");
		return s[2];
	}

	/**
	 * 
	 */
	public static boolean loginCheck(String token1, String token2) {
		if (null == token1 || token1.isEmpty() || null == token2 || token2.isEmpty()) {
			return false;
		}
		if (token1.equals(token2)) {
			return true;
		} else {
			return false;
		}
	}
}
