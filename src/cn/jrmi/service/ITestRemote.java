package cn.jrmi.service;

import java.rmi.Remote;

public interface ITestRemote extends Remote {
	public String remoteTest(String str);
}
