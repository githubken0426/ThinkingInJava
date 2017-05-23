package cn.rmi.client.main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import cn.rmi.client.inte.MyRmiInterface;

public class MyRmiClient {

	public static void main(String[] args) {
		String host = (args.length < 1) ? null : args[0];
		try {
			// �������rmiregistry����������ϵ�ע ���
			Registry registry = LocateRegistry.getRegistry(host);
			// ��ѯ�����Զ�̶���Ĵ��
			MyRmiInterface stub = (MyRmiInterface) registry.lookup("sayHello");
			// ����ʹ�ñ��ض��󷽷�����������Զ�̷���
			System.out.println(stub.sayHello());
		} catch (Exception e) {
			System.out.println("Client exception :" + e.toString());
			e.printStackTrace();
		}
	}

}
