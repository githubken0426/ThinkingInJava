package cn.rmi.client.main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import cn.rmi.client.impl.MyRmiService;
/**
 * Remote Method Invocation
 * 远程方法调用
 * @ClassName: MyRmiClient 
 * @Description: 
 * @author ken 
 * @date 2018年3月28日 上午11:45:02
 */
public class MyRmiClient {

	public static void main(String[] args) {
		String host = (args.length < 1) ? null : args[0];
		try {
			// 获得运行rmiregistry服务的主机上的注 册表
			Registry registry = LocateRegistry.getRegistry(host);
			// 查询并获得远程对象的存根
			MyRmiService stub = (MyRmiService) registry.lookup("sayHello");
			// 像在使用本地对象方法那样，调用远程方法
			System.out.println(stub.sayHello());
		} catch (Exception e) {
			System.out.println("Client exception :" + e.toString());
			e.printStackTrace();
		}
	}

}
