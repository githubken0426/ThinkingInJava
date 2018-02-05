package web.httpclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import net.sf.json.JSONObject;

public class SigntureTest {
	
	public static void main(String[] args) throws Exception {
		String mobile="18000";
//		Map<String, Object> params =new HashMap<String,Object>();
//		params.put("mobile", mobile);
		sendPostData("http://localhost/wo_security_api/app/v1/flow/order?mobile="
				+ mobile );
	}

	public static void sendPostData(String urlStr, Map<String, Object> params)
			throws Exception {
		StringBuilder sb = new StringBuilder();
		String BOUNDARY = "----WebKitFormBoundaryT1HoybnYeFOGFlBR";
		/**
		 * 封装请求参数
		 */
		for (String key : params.keySet()) {
			sb.append("--" + BOUNDARY + "\r\n");
			sb.append("Content-Disposition: form-data; name=\"" + key + "\""
					+ "\r\n");
			sb.append("\r\n");
			sb.append(params.get(key) + "\r\n");
		}
		sb.replace(sb.lastIndexOf("\r\n"), sb.length(), "");
		byte[] headerInfo = sb.toString().getBytes("UTF-8");
		byte[] endInfo = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("UTF-8");
		System.out.println(sb.toString());
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type",
				"form-data; boundary=" + BOUNDARY);
		conn.setDoOutput(true);

		OutputStream out = conn.getOutputStream();
		out.write(headerInfo);
		out.write(endInfo);

		if (conn.getResponseCode() == 200) {
			System.out.println("成功！");
		}

		BufferedReader reader = new BufferedReader(new InputStreamReader(conn
				.getInputStream()));
		String line = null;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
	}

	public static void sendPostData(String urlStr) throws Exception {
		StringBuilder sb = new StringBuilder();
		String BOUNDARY = "----WebKitFormBoundaryT1HoybnYeFOGFlBR";

		// sb.replace(sb.lastIndexOf("\r\n"), sb.length(), "");
		byte[] headerInfo = sb.toString().getBytes("UTF-8");
		byte[] endInfo = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("UTF-8");
		System.out.println("test:"+sb.toString());

		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type",
				"form-data; boundary=" + BOUNDARY);
		conn.setDoOutput(true);

		OutputStream out = conn.getOutputStream();
		out.write(headerInfo);
		out.write(endInfo);

		if (conn.getResponseCode() == 200) {
			System.out.println("成功！");
		}

		BufferedReader reader = new BufferedReader(new InputStreamReader(conn
				.getInputStream()));
		String line = reader.readLine();
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
	}

	public static String getServerTime(String urlStr) throws Exception {
		StringBuilder sb = new StringBuilder();
		String BOUNDARY = "----WebKitFormBoundaryT1HoybnYeFOGFlBR";

		// sb.replace(sb.lastIndexOf("\r\n"), sb.length(), "");
		byte[] headerInfo = sb.toString().getBytes("UTF-8");
		byte[] endInfo = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("UTF-8");
		System.out.println(sb.toString());

		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type",
				"multipart/form-data; boundary=" + BOUNDARY);
		conn.setDoOutput(true);

		OutputStream out = conn.getOutputStream();
		out.write(headerInfo);
		out.write(endInfo);

		if (conn.getResponseCode() == 200) {
			System.out.println("成功！");
		}

		BufferedReader reader = new BufferedReader(new InputStreamReader(conn
				.getInputStream()));
		String line = reader.readLine();
		JSONObject json = JSONObject.fromObject(line);
		JSONObject result = JSONObject.fromObject(json.get("result"));
		String time = result.get("server_time").toString();
		return time;
	}

}