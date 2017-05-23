package cn.jrmi.main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import cn.jrmi.service.ITestRemote;

public class TestMain {

	public static void main(String[] args)throws RemoteException, MalformedURLException, NotBoundException {
		 String url = "rmi://localhost:8089/dl_tp_wechat_cms/login.action";  
	     ITestRemote test = (ITestRemote)Naming.lookup(url);               
	     System.out.println(test.remoteTest("Lethorld"));  
	}
}
