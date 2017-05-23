package cn.rmi.client.inte;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 远程方法调用:remote method invocation
 * @author Administrator
 *
 */
public interface MyRmiInterface extends Remote {
	public String sayHello() throws RemoteException;
}
