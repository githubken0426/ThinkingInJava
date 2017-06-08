package concurrent.myfuture;

/**
 * FutureData是Future模式的关键，
 * 它实际上是真实数据RealData的代理，
 * 封装了获取RealData的等待过�?
 * 
 * @author ken
 * 2017-6-8 08:32:48
 */
public class FutureData implements Data {
	RealData realData = null; //FutureData是RealData的封�?
    boolean isReady = false;  //是否已经准备�?
    
    public synchronized void setRealData(RealData realData){
    	if(isReady)
            return;
        this.realData = realData;
        isReady = true;
        notifyAll(); //RealData已经被注入到FutureData中了，�?知getResult()方法
    }
	@Override
	public synchronized String getResult() throws InterruptedException {
		if(!isReady) {
            wait(); //�?��等到RealData注入到FutureData�?
        }
        return realData.getResult();
	}

}
