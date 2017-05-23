package cn.jrmi.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import cn.jrmi.entity.Person;

public interface PersonService extends Remote {
	public List<Person> getPersioins() throws RemoteException;  
}
