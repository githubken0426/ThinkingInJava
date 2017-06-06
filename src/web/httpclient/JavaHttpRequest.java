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
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
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
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.out.println("key= " + key + ",value= " + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection
					.getInputStream(), "utf-8"));// 防止乱码
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return result;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
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
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(sb.toString());
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
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
