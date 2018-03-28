package cn.encrypt;

import java.util.UUID;

public class TokenMain {

	public static void main(String[] args) {
		new TokenMain().run();
	}

	private void run() {
		String userid = getUUID();
		String deviceid = getUUID() + getUUID();
		String token = Encrypt.encode(userid + "_" + System.currentTimeMillis() + "_"
				+ "6c3253e5070970c9fe86ce1171ad1528e6b52a0d68a8be104c5e68851e4e2e52");
		userid = "";
		String userid2 = TokenUtil.userid(token);
		String deviceid2 = TokenUtil.device(token);

		System.out.println("userid\t\t= " + userid);
		System.out.println("deviceid\t= " + deviceid);
		System.out.println("token\t\t= " + token);
		System.out.println(token.length());
		System.out.println("userid2\t\t= " + userid2);
		System.out.println("deviceid2\t= " + deviceid2);
	}

	private String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}

}
