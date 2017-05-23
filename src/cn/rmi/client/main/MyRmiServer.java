package cn.rmi.client.main;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import cn.rmi.client.impl.MyRmiImpl;

public class MyRmiServer {

	public static void main(String[] args) {
		try {
			// ʵ����Զ�̶���ͬʱ�����˸ö���
			MyRmiImpl server = new MyRmiImpl();
			// ��ñ���RMIע������
			Registry registry = LocateRegistry.getRegistry();
			// ��ע����а�Զ�̶���
			registry.bind("sayHello", server);
			// ͨ��������׼������
			System.out.println("System already!");
		} catch (RemoteException e) {
			System.out.println("�ڽ���Զ�����ӵ������������ ��" + e.getMessage());
			System.out.println(e.toString());
		} catch (AlreadyBoundException e1) {
			System.out.println("����ע��� �а�ʱ���������⣬�����ѱ����ˣ�/n" + e1.getMessage());
		}
	}

}
