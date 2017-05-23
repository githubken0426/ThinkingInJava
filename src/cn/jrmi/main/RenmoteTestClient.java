package cn.jrmi.main;

import java.rmi.Naming;
import java.util.List;

import cn.jrmi.entity.Person;
import cn.jrmi.service.PersonService;
import cn.rmi.client.impl.MyRmiImpl;
import cn.rmi.client.inte.MyRmiInterface;

public class RenmoteTestClient {

	public static void main(String[] args) {
		try {
			// 调用远程对象，注意RMI路径与接口必须与服务器配置一致
//			PersonService personService = (PersonService) Naming
//					.lookup("rmi://127.0.0.1:7600/PersonService");
//			List<Person> personList = personService.getPersioins();
//			for (Person person : personList) {
//				System.out.println("ID:" + person.getId() + " Age:"
//						+ person.getAge() + " Name:" + person.getName());
//			}
			MyRmiInterface client = (MyRmiInterface) Naming
					.lookup("rmi://127.0.0.1:7600/PersonService");
			System.out.println(client.sayHello());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
