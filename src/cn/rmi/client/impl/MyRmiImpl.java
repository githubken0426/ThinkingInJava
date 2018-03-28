package cn.rmi.client.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRmiImpl extends UnicastRemoteObject implements MyRmiService {
	private static final long serialVersionUID = 1L;

	public MyRmiImpl() throws RemoteException {
		super();
	}

	@Override
	public String sayHello() throws RemoteException {
		return "Hello Word !";
	}

}
