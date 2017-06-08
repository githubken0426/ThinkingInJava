package concurrent.myfuture;

import java.util.concurrent.TimeUnit;

public class RealData implements Data {
	String data;
	public RealData(String data){
		try {
			//����sleep��������ʾRealData��������Ƿǳ�������
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.data=data;
	}

	@Override
	public String getResult() throws InterruptedException {
		return data;
	}

}
