package cn.rmi.client.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import cn.rmi.client.inte.MyRmiInterface;

public class MyRmiImpl extends UnicastRemoteObject implements MyRmiInterface {

	public MyRmiImpl() throws RemoteException {
		super();
	}

	@Override
	public String sayHello() throws RemoteException {
		return "Hello Word °¡!";
	}

}
