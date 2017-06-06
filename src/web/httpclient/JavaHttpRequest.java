package web.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JavaHttpRequest {

	/**
	 * ��ָ��URL����GET����������
	 * 
	 * @param url
	 *            ���������URL
	 * @param param
	 *            ����������������Ӧ���� name1=value1&name2=value2 ����ʽ��
	 * @return URL ������Զ����Դ����Ӧ���
	 * @throws IOException
	 */
	public static String sendGet(String url, Map<String, Object> param)
			throws IOException {
		StringBuffer sb = new StringBuffer();
		String result = "";
		BufferedReader in = null;
		try {
			sb.append(url);
			sb.append("?");
			Set<String> keySet = param.keySet();
			Iterator<String> it = keySet.iterator();
			boolean hasNext = it.hasNext();
			while (hasNext) {
				String key = it.next();
				Object value = param.get(key);
				sb.append(key);
				sb.append("=");
				sb.append(value);
				hasNext = it.hasNext();
				if (hasNext)
					sb.append("&");
			}
			URL realUrl = new URL(sb.toString());
			// �򿪺�URL֮�������
			URLConnection connection = realUrl.openConnection();
			// ����ͨ�õ���������
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// ����ʵ�ʵ�����
			connection.connect();
			// ��ȡ������Ӧͷ�ֶ�
			Map<String, List<String>> map = connection.getHeaderFields();
			// �������е���Ӧͷ�ֶ�
			for (String key : map.keySet()) {
				System.out.println("key= " + key + ",value= " + map.get(key));
			}
			// ���� BufferedReader����������ȡURL����Ӧ
			in = new BufferedReader(new InputStreamReader(connection
					.getInputStream(), "utf-8"));// ��ֹ����
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("����GET��������쳣��" + e);
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return result;
	}

	/**
	 * ��ָ�� URL ����POST����������
	 * 
	 * @param url
	 *            ��������� URL
	 * @param param
	 *            ����������������Ӧ���� name1=value1&name2=value2 ����ʽ��
	 * @return ������Զ����Դ����Ӧ���
	 * @throws IOException 
	 */
	public static String sendPost(String url, Map<String,Object> param) throws IOException {
		StringBuffer sb = new StringBuffer();
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			sb.append(url);
			sb.append("?");
			Set<String> keySet = param.keySet();
			Iterator<String> it = keySet.iterator();
			boolean hasNext = it.hasNext();
			while (hasNext) {
				String key = it.next();
				Object value = param.get(key);
				sb.append(key);
				sb.append("=");
				sb.append(value);
				hasNext = it.hasNext();
				if (hasNext)
					sb.append("&");
			}
			URL realUrl = new URL(url);
			// �򿪺�URL֮�������
			URLConnection conn = realUrl.openConnection();
			// ����ͨ�õ���������
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// ����POST�������������������
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// ��ȡURLConnection�����Ӧ�������
			out = new PrintWriter(conn.getOutputStream());
			// �����������
			out.print(sb.toString());
			// flush������Ļ���
			out.flush();
			// ����BufferedReader����������ȡURL����Ӧ
			in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("���� POST ��������쳣��" + e);
			e.printStackTrace();
		}
		// ʹ��finally�����ر��������������
		finally {
			if (out != null) {
				out.close();
			}
			if (in != null) {
				in.close();
			}
		}
		return result;
	}

	static String getUrl = "http://192.168.1.77/app/v2/open/server/resources";
	static String postUrl = "http://192.168.1.77/app/v2/clerk/order/list";

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("system_bj", "android");
		try {
			String result = sendGet(getUrl,map);
			System.out.println(result);
			
			System.out.println("************************");
			Map<String, Object> pMap = new HashMap<String, Object>();
			pMap.put("token", "android");
			pMap.put("t", "11");
			pMap.put("sign", "tet");
			String post=sendPost(postUrl, pMap);
			System.out.println(post);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
