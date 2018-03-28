package cn.rmi.jrmi.main;

import java.rmi.Naming;
import java.util.List;

import cn.rmi.client.impl.MyRmiService;
import cn.rmi.jrmi.entity.Person;
import cn.rmi.jrmi.service.PersonService;

public class RenmoteTestClient {
	public static void main(String[] args) {
		try {
			// 调用远程对象，注意RMI路径与接口必须与服务器配置一致
			/*PersonService personService = (PersonService) Naming.lookup("rmi://127.0.0.1:7600/PersonService");
			List<Person> personList = personService.getPersioins();
			for (Person person : personList) {
				System.out.println("ID:" + person.getId() + " Age:" + person.getAge() + " Name:" + person.getName());
			}*/
			MyRmiService client = (MyRmiService) Naming.lookup("rmi://127.0.0.1:7600/PersonService");
			System.out.println(client.sayHello());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
