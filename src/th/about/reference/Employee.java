package th.about.reference;

/**
 * ʵ����
 * @author Administrator
 * 2015��9��16��
 */
public class Employee {
	private String id;// ��Ա�ı�ʶ����  
    private String name;// ��Ա����  
    private String department;// �ù�Ա���ڲ���  
    private String phone;// �ù�Ա��ϵ�绰  
    private int salary;// �ù�Աн��  
    private String origin;// �ù�Ա��Ϣ����Դ  
	
	public Employee(){}
	public Employee(String id,String name,String department,String phone){
		this.id=id;
		this.name=name;
		this.department=department;
		this.phone=phone;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
}
