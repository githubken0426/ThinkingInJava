package th.about.reference;

/**
 * 实体类
 * @author Administrator
 * 2015年9月16日
 */
public class Employee {
	private String id;// 雇员的标识号码  
    private String name;// 雇员姓名  
    private String department;// 该雇员所在部门  
    private String phone;// 该雇员联系电话  
    private int salary;// 该雇员薪资  
    private String origin;// 该雇员信息的来源  
	
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
