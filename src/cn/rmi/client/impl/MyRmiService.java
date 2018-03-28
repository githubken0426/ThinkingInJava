package cn.rmi.client.impl;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 远程调用:remote method invocation
 * @author Administrator
 *
 */
public interface MyRmiService extends Remote {
	public String sayHello() throws RemoteException;
}
