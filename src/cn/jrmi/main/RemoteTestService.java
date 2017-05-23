package cn.jrmi.main;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import cn.jrmi.service.PersonService;
import cn.jrmi.service.impl.PersonServiceImpl;
import cn.rmi.client.impl.MyRmiImpl;

public class RemoteTestService {

	public static void main(String[] args) {
		try {
			//PersonService personService=new PersonServiceImpl();
			MyRmiImpl server = new MyRmiImpl();
			//ע��ͨѶ�˿�
			LocateRegistry.createRegistry(7600);
			//ע��ͨѶ·��
			Naming.rebind("rmi://127.0.0.1:7600/PersonService", server);
			System.out.println("Service Start!");
			} catch (Exception e) {
			e.printStackTrace();
			}
	}
}
