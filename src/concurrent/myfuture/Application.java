package concurrent.myfuture;

import java.util.concurrent.TimeUnit;

public class Application {
	public static void main(String[] args) {
		Client client = new Client();
		// ������������أ���Ϊ��ȡ����FutureData������RealData
		try {
			Data data = client.request("name");
			/**
			 * ���������һ��sleep���������ҵ���߼��Ĵ���, 
			 * �ڴ�����Щҵ���߼������У�RealDataҲ���ڴ������Ӷ���������õȴ�ʱ��
			 */
			TimeUnit.SECONDS.sleep(5);
			// ʹ����ʵ����
			System.out.println("����=" + data.getResult());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
