package cn.rmi.client.inte;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Զ�̷�������:remote method invocation
 * @author Administrator
 *
 */
public interface MyRmiInterface extends Remote {
	public String sayHello() throws RemoteException;
}
