package concurrent.myfuture;

public class Client {
	public Data request(final String string) {
		final FutureData futureData = new FutureData();
		new Thread(new Runnable() {
			@Override
			public void run() {
				// RealData�Ĺ������������Է��ڵ������߳�������
				RealData realData = new RealData(string);
				futureData.setRealData(realData);
			}
		}).start();

		return futureData; // ��ֱ�ӷ���FutureData
	}
}
