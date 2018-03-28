package cn.rmi.client.main;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import cn.rmi.client.impl.MyRmiImpl;

public class MyRmiServer {
	public static void main(String[] args) {
		try {
			// 实例化远程对象，同时导出了该对象
			MyRmiImpl server = new MyRmiImpl();
			// 获得本地RMI注册表对象
			Registry registry = LocateRegistry.getRegistry();
			// 在注册表中绑定远程对象
			registry.bind("sayHello", server);
			// 通告服务端已准备好了
			System.out.println("System already!");
		} catch (RemoteException e) {
			System.out.println("在建立远程连接的情况出现了异 常" + e.getMessage());
			System.out.println(e.toString());
		} catch (AlreadyBoundException e1) {
			System.out.println("在向注册表 中绑定时出现了问题，名字已被绑定了！/n" + e1.getMessage());
		}
	}
}
