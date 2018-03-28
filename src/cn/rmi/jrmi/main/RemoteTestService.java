package cn.rmi.jrmi.main;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import cn.rmi.client.impl.MyRmiImpl;
import cn.rmi.jrmi.service.PersonService;
import cn.rmi.jrmi.service.PersonServiceImpl;

public class RemoteTestService {

	public static void main(String[] args) {
		try {
			//PersonService personService=new PersonServiceImpl();
			MyRmiImpl server = new MyRmiImpl();
			//
			LocateRegistry.createRegistry(7600);
			//
			Naming.rebind("rmi://127.0.0.1:7600/PersonService", server);
			System.out.println("Service Start!");
			} catch (Exception e) {
			e.printStackTrace();
			}
	}
}
