package web.httpclient;

import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class SubmitUtil {
	public static void main(String[] args) {
		HttpClient httpClient = new HttpClient();
		String url = "http://193.167.13.21/setup.cgi";
		PostMethod postMethod = new PostMethod(url);
		// ������������ֵ
		NameValuePair[] data = { new NameValuePair("ID", "11"),
				new NameValuePair("mtg", "0"),
				new NameValuePair("haveCookie", "0"),
				new NameValuePair("backID", "30"),
				new NameValuePair("psw", "password") };
		// ������ֵ����postMethod��
		postMethod.setRequestBody(data);
		// ִ��postMethod
		int statusCode = 0;
		try {
			statusCode = httpClient.executeMethod(postMethod);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// HttpClient����Ҫ����ܺ�̷����������POST��PUT�Ȳ����Զ�����ת��
		// 301����302
		if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY
				|| statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
			// ��ͷ��ȡ��ת��ĵ�ַ
			Header locationHeader = postMethod.getResponseHeader("location");
			String location = null;
			if (locationHeader != null) {
				location = locationHeader.getValue();
				System.out.println("The page was redirected to:" + location);
			} else {
				System.err.println("Location field value is null.");
			}
			return;
		} else {
			System.out.println(postMethod.getStatusLine());
			String str = "";
			try {
				str = postMethod.getResponseBodyAsString();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(str);
		}
		postMethod.releaseConnection();
		return;
	}
}
